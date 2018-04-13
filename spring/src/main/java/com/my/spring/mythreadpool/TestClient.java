package com.my.spring.mythreadpool;

public class TestClient {
    public static void main(String[] args) {
        MyThreadPool threadPool=new SimpeThreadPool<>(5);
        Thread t1=new Thread(new TestThread());
        Thread t2=new Thread(new TestThread());
        Thread t3=new Thread(new TestThread());
        Thread t4=new Thread(new TestThread());
        Thread t5=new Thread(new TestThread());
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);
        threadPool.execute(t4);
        threadPool.execute(t5);
    }

}
