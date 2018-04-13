package com.my.spring.mythreadpool;

public class TestThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
