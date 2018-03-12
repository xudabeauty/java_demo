package com.my.behavior_pattern.stragegy;

public class Context {
    
    private Strategy strategy;
    public Context(Strategy _sStrategy) {
        this.strategy=_sStrategy;
    }
    
    public void doAnything() {
        strategy.doSomething();
    }

}
