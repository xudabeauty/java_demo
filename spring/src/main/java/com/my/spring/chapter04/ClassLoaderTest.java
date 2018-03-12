package com.my.spring.chapter04;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        System.out.println("current laoder"+loader);
        System.out.println("parent loader"+loader.getParent());
        System.out.println("grandparent loader"+loader.getParent().getParent());
    }

}
