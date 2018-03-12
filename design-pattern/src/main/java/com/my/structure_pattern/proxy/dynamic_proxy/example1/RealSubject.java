package com.my.structure_pattern.proxy.dynamic_proxy.example1;

public class RealSubject implements Subject{

    public void doSomething(String args) {
        System.out.println(args);
    }
}
