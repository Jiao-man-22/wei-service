package com.jiaoke.weiservice.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaoke.weiservice.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

//    int create(Payment payment);
    int getMaxId();
}
