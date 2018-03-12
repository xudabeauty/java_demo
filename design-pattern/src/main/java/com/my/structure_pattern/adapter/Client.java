package com.my.structure_pattern.adapter;

public class Client {
public static void main(String[] args) {
    Target target=new ConcreteTarget();
    target.request();
    
    Target adapeeTarget=new Adapter();
    adapeeTarget.request();
}
}
