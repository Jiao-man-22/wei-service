package com.jiaoke.file.server.controller;

import com.jiaoke.file.server.annotations.CustomAnnotation;
import com.jiaoke.file.server.po.vo.MyEntity;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RestController
public class Test {

    //  写自定义校验参数 但是 当 这注解在 请求参数 上面 不会走 校验 逻辑
    @GetMapping("/valid")
    public void valid(@CustomAnnotation String name ){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        MyEntity entity = new MyEntity();
        entity.setMyField("wwwww");
       // Set<ConstraintViolation<MyEntity>> violations = validator.validate(entity);
       // Set<ConstraintViolation<String>> validate = validator.validate(name);
    }
}
