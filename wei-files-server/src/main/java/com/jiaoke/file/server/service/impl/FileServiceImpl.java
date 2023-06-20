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

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Log4j2
public class FileServiceImpl extends ServiceImpl<FileMapper, BaseFileInfo> implements IFileService {

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

                File parentFileDir = new File(file_server_url, "jiao01-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                if (parentFileDir.exists() && parentFileDir.isDirectory()) {
                    f.transferTo(new File(parentFileDir, FileUtil.generateFileName()
                            + "." + FileUtil.getExtension(f.getOriginalFilename())));
                } else {
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
}
