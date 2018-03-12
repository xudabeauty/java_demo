package com.my.structure_pattern.bridge;

public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    
    public void request() {
        super.request();
        super.getImpl().doAnything();
    }

}
