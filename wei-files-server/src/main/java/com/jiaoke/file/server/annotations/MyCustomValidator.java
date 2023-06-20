package com.jiaoke.file.server.annotations;

import cn.hutool.core.collection.CollectionUtil;
import com.jiaoke.file.server.enums.FileType;
import com.jiaoke.file.server.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MyCustomValidator implements ConstraintValidator<MyCustomValidation, MultipartFile[]>  {


    public void initialize(MyCustomValidation constraint) {
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(MultipartFile[] multipartFiles, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("------------------------isValid---------------------");
        if (multipartFiles == null)return false;
        //拦截img文件
        List<String> fileExtension = new ArrayList<>(multipartFiles.length);
        for (MultipartFile f:multipartFiles) {
            String extension = FileUtil.getExtension(f.getOriginalFilename());
            fileExtension.add(extension);
        }

        FileType[] values = FileType.values();
        List<String> patternExtension = new ArrayList<>(values.length);
        for (FileType v:values) {
            patternExtension.add(v.getSuffix());
        }

        if (CollectionUtil.containsAll(patternExtension,fileExtension)) {
            return  true;
        } else {
            log.info("=========参数校验不合法======");
            return false;
        }
    }
}
