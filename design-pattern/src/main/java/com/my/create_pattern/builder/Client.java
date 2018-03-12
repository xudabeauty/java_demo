package com.my.create_pattern.builder;

public class Client {
    public static void main(String[] args) {
        Director director=new Director();
        Product productAB=director.createProductAB();
        productAB.doSomething();
    }

}
