package com.jiaoke.weiservice.payment.service;

import com.jiaoke.weiservice.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id")long id);

}
