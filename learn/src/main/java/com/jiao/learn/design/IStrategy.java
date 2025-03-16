package com.jiao.learn.design;

/**
 *
 * 策略（Strategy）模式的定义：该模式定义了一系列算法，
 * 并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。
 * 策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。
 *
 * 抽象策略(Strategy)类
 * 具体策略(Concrete Strategy)类
 * 环境(Context)类
 * @author 29359
 */
public interface IStrategy {

    abstract void eat();
}
