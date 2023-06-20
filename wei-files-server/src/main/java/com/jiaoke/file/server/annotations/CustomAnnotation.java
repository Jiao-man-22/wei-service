package com.jiaoke.file.server.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyCustomAnnotation.class)
public @interface CustomAnnotation {
    String message() default "Invalid input";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
