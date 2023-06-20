package com.jiaoke.file.server.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaoke.file.server.annotations.CustomAnnotation;
import com.jiaoke.file.server.annotations.MyCustomValidation;
import com.jiaoke.file.server.po.vo.MyEntity;
import com.jiaoke.file.server.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

@RestController
public class CommonUploadController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/uploadMultiFile")
    public String uploadMultiFile( @RequestParam("files")  @MyCustomValidation MultipartFile[] files) {
// todo 业务实现失败
//        //拿到校验工厂
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        //得到校验器
//        Validator validator = factory.getValidator();
//        //执行验证 艹艹
//        Set<ConstraintViolation<MultipartFile[]>> validate = validator.validate(files);
        if (files == null || files.length == 0 )return "NG";
        boolean b = fileService.uploadMultiFile(files);

        return String.valueOf(b);
    }

    // response.getOutputStream()
    @GetMapping("/downloadFile/{fileId}")
    public void downloadFile(@PathVariable String fileId, HttpServletResponse res, HttpServletRequest req){

        try {
            fileService.downloadFile(fileId, res, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
