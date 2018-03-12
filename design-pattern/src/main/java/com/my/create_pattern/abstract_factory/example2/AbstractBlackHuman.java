package com.my.create_pattern.abstract_factory.example2;

public abstract class AbstractBlackHuman implements Human {
    public void getColor() {
        System.out.println("我是黑种人");
    }
    public void getTalk() {
        System.out.println("我说话有点大舌头");
    }
}
