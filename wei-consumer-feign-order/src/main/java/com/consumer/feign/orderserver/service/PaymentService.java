package com.consumer.feign.orderserver.service;

import com.jiaoke.weiservice.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
@FeignClient(value="WEI-SERVICE-PAYMENT")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult queryById(@PathVariable("id") Long id);


    //调用生产者微服务名称为wei-service-payment下边的模拟超时的接口
    @GetMapping("/payment/test-feign/timeout")
    String PaymentFeignTimeOut() throws InterruptedException;


}
