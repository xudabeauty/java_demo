package com.my.create_pattern.abstract_factory.example2;

public abstract class AbstractYellowHuman implements Human {
    public void getColor() {
        System.out.println("我是黄种人");
    }
    public void getTalk() {
        System.out.println("我说话很温柔");
    }
}
