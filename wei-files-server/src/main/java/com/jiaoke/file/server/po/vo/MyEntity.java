package com.jiaoke.file.server.po.vo;

import com.jiaoke.file.server.annotations.CustomAnnotation;
import lombok.Data;

@Data
public class MyEntity {
    @CustomAnnotation
    private String myField;
}
