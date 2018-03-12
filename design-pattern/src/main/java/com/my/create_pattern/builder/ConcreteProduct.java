package com.my.create_pattern.builder;

public class ConcreteProduct extends Builder{
    private Product product=new Product();

    @Override
    public void setPartA() {
        System.out.println("set part A");
    }

    @Override
    public void setPartB() {
        System.out.println("set part B");
    }
    
    @Override
    public Product builder() {
        return product;
    }
}
