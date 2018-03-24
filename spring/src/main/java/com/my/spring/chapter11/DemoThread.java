package com.my.spring.chapter11;

public class DemoThread  implements Runnable{
    private SequenceNumber sequenceNumber;
    
    public DemoThread(SequenceNumber sequence) {
       this.sequenceNumber=sequence;
    }
    public void run() {
       for(int i=0;i<3;i++) {
           System.out.println("Thread-"+Thread.currentThread().getName()+" sn:"+sequenceNumber.getNextNum());
       }
    }
}
