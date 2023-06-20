package com.jiaoke.file.server.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyCustomValidator.class)
public @interface MyCustomValidation {
    String message() default "自定义校验器校验失败";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
