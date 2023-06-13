package com.consumer.feign.orderserver.controller;

import com.consumer.feign.orderserver.service.PaymentService;
import com.jiaoke.weiservice.entity.Payment;
import com.jiaoke.weiservice.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/feign/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult result = paymentService.queryById(id);
        return result;
    }

    @GetMapping("/feign/consumer/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException {
        return paymentService.PaymentFeignTimeOut();
    }









}
