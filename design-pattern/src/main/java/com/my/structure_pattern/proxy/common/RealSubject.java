package com.my.structure_pattern.proxy.common;

public class RealSubject implements Subject {

    public void request() {
        System.out.println("dosomething");
    }
}
