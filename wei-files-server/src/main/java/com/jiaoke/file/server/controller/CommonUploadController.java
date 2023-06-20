package com.jiaoke.file.server.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaoke.file.server.annotations.CustomAnnotation;
import com.jiaoke.file.server.annotations.MyCustomValidation;
import com.jiaoke.file.server.po.vo.MyEntity;
import com.jiaoke.file.server.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
public class CommonUploadController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/uploadMultiFile")
    public String uploadMultiFile( @RequestParam("files")  @MyCustomValidation MultipartFile[] files) {

        //拿到校验工厂
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //得到校验器
        Validator validator = factory.getValidator();
        //执行验证 艹艹
        Set<ConstraintViolation<MultipartFile[]>> validate = validator.validate(files);
        boolean b = fileService.uploadMultiFile(files);

        return String.valueOf(b);
    }

}
