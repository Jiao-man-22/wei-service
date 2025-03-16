package com.jiao.learn.design;

public class StrategyA implements  IStrategy {
    @Override
    public void eat() {
        System.out.println("我用刀叉吃！！ ");
    }
}
