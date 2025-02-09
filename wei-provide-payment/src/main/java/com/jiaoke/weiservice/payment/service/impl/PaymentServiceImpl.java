//package com.jiaoke.weiservice.payment.service.impl;
//
//import cn.hutool.core.bean.BeanUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.jiaoke.weiservice.entity.Payment;
//import com.jiaoke.weiservice.payment.dao.PaymentDao;
//import com.jiaoke.weiservice.payment.service.IPaymentService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.Map;
//
//@Log4j2
//@Service
//public class PaymentServiceImpl extends ServiceImpl implements IPaymentService {
//
//    @Resource
//    private PaymentDao paymentDao;
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public int create(Payment payment) {
//
//        Payment pay = paymentDao.selectById(payment.getId());
//        int flag = 0;
//        if (pay == null && BeanUtil.isNotEmpty(payment,"id") ){
//            flag = paymentDao.insert(payment);
//        }else if(pay != null && payment != null) {
//            // 如果 payment 在数据库里已经存在 拿出数据库里面最后一条 id++
//            QueryWrapper<Payment> paymentQueryWrapper = new QueryWrapper<>();
//
//            paymentQueryWrapper.select("MAX(id) AS MaxId");
//
//            Map map = this.getMap(paymentQueryWrapper);
//
//            Long maxId =Long.valueOf(String.valueOf(map.get("MaxId"))) ;
//
//            Long insetID =  ++ maxId ;
//
//            log.info("数据 存在默认自动递增 id  {%d}" + insetID);
//
//            payment.setId(Long.valueOf(insetID));
//
//            flag = paymentDao.insert(payment);
//        }
//        return flag;
//    }
//
//    @Override
//    public Payment queryById(long id) {
//        return paymentDao.selectById(id);
//    }
//}
