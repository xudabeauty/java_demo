package com.my.structure_pattern.adapter;

public class Adapter extends Adaptee implements Target {

    public void request() {
        super.doSoemthing();
    }
}
