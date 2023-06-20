package com.jiaoke.file.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IFileService extends IService<BaseFileInfo> {

    boolean uploadMultiFile(MultipartFile[] files);

    void downloadFile(String id, HttpServletResponse res, boolean isOnline) throws IOException;



}
