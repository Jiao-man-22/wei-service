package com.jiaoke.file.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaoke.file.server.dao.FileMapper;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import com.jiaoke.file.server.service.IFileService;
import com.jiaoke.file.server.util.FileUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Log4j2
public class FileServiceImpl extends ServiceImpl<FileMapper, BaseFileInfo> implements IFileService {

    //模拟文件服务器地址
    @Value("E:\\FILE_SERVER")
    private String file_server_url;


    private FileMapper fileMapper;

    public FileServiceImpl(@Autowired FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public boolean uploadMultiFile(MultipartFile[] files) {

        for (MultipartFile f : files) {
            try {
                String dateFormatTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                File parentFileDir = new File(file_server_url, "jiao01-" + dateFormatTime);
                long timestamp = parentFileDir.lastModified();
                Date creationTime = new Date(timestamp);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedTime = formatter.format(creationTime);

                if (parentFileDir.exists() && parentFileDir.isDirectory()) {
                    String snowID = FileUtil.generateFileName();
                    f.transferTo(new File(parentFileDir, snowID
                            + "." + FileUtil.getExtension(f.getOriginalFilename())));
                    // 基本信息入库
                    BaseFileInfo baseFileInfo = new BaseFileInfo();
                    baseFileInfo.setFileId(snowID);
                    baseFileInfo.setFileLocation(parentFileDir.getAbsolutePath());
                    baseFileInfo.setFileRealName(f.getOriginalFilename());
                    // 坑 LocalDateTime 解析的 是 localDate 和 localTime 两个 对象
                    LocalDateTime parse = LocalDateTime.parse(dateFormatTime+" 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    baseFileInfo.setCreateTime(parse);
                    baseFileInfo.setCreator("admin");
                    try {
                        fileMapper.insert(baseFileInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // 比较是不是 同一天文件
                } else if (!dateFormatTime.equals(formattedTime)){
                    parentFileDir.delete();
                    parentFileDir.mkdirs();
                }
                log.info("--------- 上传成功 -------");
            } catch (IOException e) {
                log.error(e.getMessage() + "line : 38 ");
                return false;
            }
        }
        return true;
    }

    @Override
    public void downloadFile(String id, HttpServletResponse res, boolean isOnline) throws IOException {
        if (id == null)return ;
        BaseFileInfo baseFileInfo = fileMapper.selectById(id);
        if (baseFileInfo == null) return  ;
        // 牵扯到 表设计
        // 1 文件 服务器 存储带后缀 方便 查看 但 后缀 就要单独存放 不然每次得截取 文件后缀  do
        // 2 文件服务器 不存 后缀比较 简单高效 但是 不方便维护 文件服务器
        if (baseFileInfo != null){
            File file = new File(baseFileInfo.getFileLocation(),
                    baseFileInfo.getFileId() + "." + FileUtil.getExtension(baseFileInfo.getFileRealName()));
            if (!file.exists()){
                try {
                    res.sendError(404 ,"文件不存咋 ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = (br.read(buf))) != -1 ){
                // 这 调用 getOutputStream 已经和 浏览器客户端 建立连接了  ；不需要把 输出流返回 （× 思维误区）
                res.getOutputStream().write(buf,0,len);
            }
            res.getOutputStream().flush();
            //????? 抄的，这步我也懵的一笔
            if (!res.isCommitted())  res.reset(); // 非常重要

            if (isOnline) { // 在线打开方式
                URL u = new URL("file:///" + baseFileInfo.getFileLocation());
                res.setContentType(u.openConnection().getContentType());
                res.setHeader("Content-Disposition", "inline; filename=" + file.getName());
                // 文件名应该编码成UTF-8
            } else { // 纯下载方式
                res.setContentType("application/x-msdownload");
                res.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            }
            if (res.getOutputStream() != null) res.getOutputStream().close();

        }
        return ;
    }
}
