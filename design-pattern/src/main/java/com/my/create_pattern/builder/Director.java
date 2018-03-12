package com.my.create_pattern.builder;

public class Director {
    Builder builder=new ConcreteProduct();
    public Product createProductAB() {
        builder.setPartA();
        builder.setPartB();
        return builder.builder();
    }
    
    public Product createProductBA() {
        builder.setPartB();
        builder.setPartA();
        return builder.builder();
    }
}
