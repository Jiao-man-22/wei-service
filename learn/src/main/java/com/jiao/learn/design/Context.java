package com.jiao.learn.design;

public class Context {

    private IStrategy strategy;

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void useEat(){
        strategy.eat();
    }

    public static void main(String[] args) {
        Context context = new Context();
        StrategyB strategyB = new StrategyB();
        context.setStrategy(strategyB);
        context.useEat();

    }

}
