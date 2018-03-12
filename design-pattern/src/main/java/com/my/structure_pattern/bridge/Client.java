package com.my.structure_pattern.bridge;

public class Client {
    public static void main(String[] args) {
        Implementor implementor=new ConcreteImplementor1();
        Abstraction abstraction=new RefinedAbstraction(implementor);
        abstraction.request();
    }

}
