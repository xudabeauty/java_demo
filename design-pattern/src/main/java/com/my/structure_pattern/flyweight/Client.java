package com.my.structure_pattern.flyweight;

public class Client {
    public static void main(String[] args) {
        Flyweight flyweight=FlyweightFactory.getInstance("aa");
        flyweight.operate();
    }

}
