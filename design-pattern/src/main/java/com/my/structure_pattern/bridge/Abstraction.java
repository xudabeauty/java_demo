package com.my.structure_pattern.bridge;

public abstract class Abstraction {
    
    private Implementor implementor;
    public Abstraction(Implementor implementor) {
        this.implementor=implementor;
    }
    
    public void request() {
        this.implementor.dosomething();
    }
    public Implementor getImpl() {
        return this.implementor;
    }
}
