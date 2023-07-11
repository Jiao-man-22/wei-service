package com.jiaoke.file.server.po.vo;

import com.jiaoke.file.server.annotations.CustomAnnotation;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import lombok.Data;

@Data
public class MyEntity extends BaseFileInfo {
    @CustomAnnotation
    private String myField;
}
