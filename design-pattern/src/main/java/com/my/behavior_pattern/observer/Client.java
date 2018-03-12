package com.my.behavior_pattern.observer;

public class Client {
    public static void main(String[] args) {
        Observer observer=new ConcreteObserver();
        Observer observer2=new ConcreteObserver();
        Subject subject=new ConcreteSubject();
        subject.addObserver(observer);
        subject.addObserver(observer2);
        subject.notifyObserver();
    }

}
