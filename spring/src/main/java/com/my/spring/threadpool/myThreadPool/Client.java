package com.my.spring.threadpool.myThreadPool;

public class Client {
    
    public static void main(String[] args) {
        ThreadPool threadPool=new DefaultThreadPool(1);
         Thread t1=new Thread(new MyThread("t1"));
         Thread t2=new Thread(new MyThread("t2"));
         threadPool.execute(t1);
         threadPool.execute(t2);
        
    }

}
