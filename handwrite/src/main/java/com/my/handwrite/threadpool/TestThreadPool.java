package com.my.handwrite.threadpool;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPool pool=new DefaultThreadPool<MyThread>();
        Thread t1=new Thread(new MyThread());
        Thread t2=new Thread(new MyThread());
        Thread t3=new Thread(new MyThread());
        pool.executor(t1);
        pool.executor(t2);
        pool.executor(t2);
    }

}
