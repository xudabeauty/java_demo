package com.my.spring.chapter07.advice;

public class NavieWaiter implements Waiter {

    @Override
    public void greeting(String name) {
        System.out.println("greet to "+name+"....");
    }

    @Override
    public void serverTo(String name) {
        System.out.println("server to "+name+"..");
    }
}
