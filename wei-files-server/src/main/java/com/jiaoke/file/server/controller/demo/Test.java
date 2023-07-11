package com.jiaoke.file.server.controller.demo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaoke.file.server.annotations.CustomAnnotation;
import com.jiaoke.file.server.dao.FileMapper;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import com.jiaoke.file.server.po.vo.MyEntity;
import com.jiaoke.file.server.po.vo.ParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


@RestController
public class Test extends ServiceImpl<FileMapper, BaseFileInfo> {

    @Autowired
    private FileMapper fileMapper;

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
    @GetMapping("/testOutputStream")
    void testOutputStream(HttpServletResponse res){
        ServletOutputStream ot1 = null;
        ServletOutputStream ot2 = null;
        try {
            //拿到是同一个OutputStream
            ot1 = res.getOutputStream();
            ot1.write(1);
            ot1.flush();


            ot2 = res.getOutputStream();
            //ot2.write(2);
            ot2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ot1 == ot2);
    }

    // 测试参数封装
    @GetMapping("/wrapDTO")
    void wrapDTO(ParamDTO paramDTO){
        System.out.println(paramDTO.getParamDTOPro());
        System.out.println(paramDTO.getFileId());
    }

    //测试
    @PostMapping("/doBatch")
    void doBatch(){

        ArrayList<BaseFileInfo> baseFileInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseFileInfo baseFileInfo = new BaseFileInfo();
            baseFileInfo.setUpdateTime(LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            baseFileInfos.add(baseFileInfo);
        }
        boolean b = saveOrUpdateBatch(baseFileInfos, 3);
        System.out.println(b);
    }
}
