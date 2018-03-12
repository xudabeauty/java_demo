package com.my.create_pattern.abstract_factory.example2;

public abstract class AbstractWhiteHuman implements Human{
    public void getColor() {
        System.out.println("我是白种人");
    }
    public void getTalk() {
        System.out.println("我说话有点快");
    }
}
