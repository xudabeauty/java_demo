package com.my.create_pattern.factory_method;

public class Client {
    public static void main(String[] args) {
        Factory factory=new ConcretFactory();
        ConcrectProductA productA=factory.create(ConcrectProductA.class);
        ConcrectProductB productB=factory.create(ConcrectProductB.class);
        productA.doSomething();
        productB.doSomething();
    }

}
