package com.my.spring.threadpool.myThreadPool;

public class MyThread implements Runnable {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        System.out.println(threadName+"running");
    }


}
