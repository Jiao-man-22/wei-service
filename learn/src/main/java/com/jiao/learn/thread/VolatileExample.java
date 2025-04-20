package com.jiao.learn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileExample {

    private volatile static int  count = 0 ;

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Lock lock = new ReentrantLock();

        // 线程B：等待标志变量被设置
        Thread threadB = new Thread(() -> {
            System.out.println("VolatileExample 当前值 ： " + VolatileExample.count);
            lock.lock();
            for (int i = 0; i < 10000 ; i++) {
                VolatileExample.count ++ ;
            }
            lock.unlock();
            System.out.println("线程B 修改 VolatileExample  ： " + VolatileExample.count);
        });
        threadB.start();


        // 线程B：等待标志变量被设置
        Thread threadA = new Thread(() -> {
            System.out.println("VolatileExample 当前值 ： " + VolatileExample.count);
            for (int i = 0; i < 10000 ; i++) {
               int x = VolatileExample.count ^ VolatileExample.count ;
               if (x > 0 ){
                   System.out.println(VolatileExample.count );
               }

            }
            System.out.println("线程A 修改 VolatileExample  ： " + VolatileExample.count);
        });
        threadA.start();


    }
}
