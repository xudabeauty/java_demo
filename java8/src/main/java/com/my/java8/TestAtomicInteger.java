package com.my.java8;

public class TestAtomicInteger {
    public static void main(String[] args) {
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger(5);
        System.out.println(myAtomicInteger);
        myAtomicInteger.decrementAndGet();
        System.out.println(myAtomicInteger.get());
    }
}
