package com.my.spring.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadExecutor {
    public static void main(String[] args) {
      //  ExecutorService executorService = Executors.newSingleThreadExecutor();
       // ExecutorService  executorService=Executors.newFixedThreadPool(6);
       // ExecutorService executorService=Executors.newCachedThreadPool();
        ExecutorService executorService=Executors.newCachedThreadPool();
        Thread t1=new MyThread("t1");
        Thread t2=new MyThread("t2");
        Thread t3=new MyThread("t3");
        Thread t4=new MyThread("t4");
        Thread t5=new MyThread("t5");
        Thread t6=new MyThread("t6");
        Thread t7=new MyThread("t7");
        Thread t8=new MyThread("t8");
        Thread t9=new MyThread("t9");
        Thread t10=new MyThread("t10");
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        executorService.execute(t6);
        executorService.execute(t7);
        executorService.execute(t8);
        executorService.execute(t9);
        executorService.execute(t10);
    }

}
