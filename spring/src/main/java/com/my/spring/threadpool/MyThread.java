package com.my.spring.threadpool;

public class MyThread extends Thread{
    private String threadName;
    public MyThread(String name) {
        this.threadName=name;
    }
    @Override
    public void run() {
        System.out.println(threadName+"is running");
    }

}
