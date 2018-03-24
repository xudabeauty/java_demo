package com.my.spring.chapter11;

public class TestClient {
    //给自己跪了，就这几行代码居然报空指针
    public static void main(String[] args) {
        SequenceNumber sequenceNumber=new SequenceNumber();
        //三个线程共享一个SequenceNumber对象
       Thread t1=new Thread(new DemoThread(sequenceNumber));
      Thread t2=new Thread(new DemoThread(sequenceNumber));
       Thread t3=new Thread(new DemoThread(sequenceNumber));
        t1.start();
       t2.start();
        t3.start();
    }

}
