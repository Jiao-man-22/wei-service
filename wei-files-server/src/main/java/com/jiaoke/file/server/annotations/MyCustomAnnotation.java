package com.jiaoke.file.server.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MyCustomAnnotation implements ConstraintValidator<CustomAnnotation, String>{


    @Override
    public void initialize(CustomAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("ssssssss" + s);
        System.out.println("=====================正在执行校验逻辑===========");
        return false;
    }
}
