package com.my.behavior_pattern.observer;

public class ConcreteObserver extends Observer {
    public void update() {
        System.out.println("收到通知，更新消息");
    }
}
