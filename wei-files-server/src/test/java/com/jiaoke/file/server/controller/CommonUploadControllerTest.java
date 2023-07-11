package com.jiaoke.file.server.controller;

import com.jiaoke.file.server.dao.FileMapper;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
public class CommonUploadControllerTest {

    @Resource
    private FileMapper fileMapper;

    @Test
    public void getInfo(){
        BaseFileInfo baseFileInfo = fileMapper.selectById(1L);
        System.out.println(baseFileInfo.getFileId());
    }


}