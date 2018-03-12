package com.my.structure_pattern.adapter;

public class ConcreteTarget implements Target {

    public void request() {
        System.out.println("适配前的功能");
    }
    

}
