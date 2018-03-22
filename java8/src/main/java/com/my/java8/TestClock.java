package com.my.java8;

public class TestClock {
    public static void main(String[] args) {
        final Object obj1=new Object();
        final Object obj2=new Object();
        Thread threadA=new Thread(new Runnable() {
            
            public void run() {
                synchronized(obj1) {
                    System.out.println("now  obj1 in ThreadA ");
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                synchronized(obj2) {
                    System.out.println("now  obj2 in ThradB");
                }
            }
        });
        
        Thread threadB=new Thread(new Runnable() {
            
            public void run() {
                synchronized(obj2) {
                    System.out.println("now obj2 in ThreadB");
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                synchronized(obj1) {
                    System.out.println("now obj1 in ThreadB");
                }
            }
        });
        
        threadA.start();
        threadB.start();
    }

}
