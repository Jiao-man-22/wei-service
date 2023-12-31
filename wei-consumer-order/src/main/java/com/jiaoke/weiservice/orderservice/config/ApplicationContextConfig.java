package com.jiaoke.weiservice.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

//    这里服务间的调用，我们使用了RestTemplate，
//    RestTemplate提供了多种便捷访问远程Http服务的方法，
//    是一种简单便捷的访问restful服务的模板类，
//    是spring提供的用于访问Rest服务的客户端模板工
    @Bean
    public RestTemplate getRestTemplate(){
    return new RestTemplate();
    }
}
