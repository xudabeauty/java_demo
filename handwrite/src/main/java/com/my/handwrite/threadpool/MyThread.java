package com.my.handwrite.threadpool;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
    }

}
