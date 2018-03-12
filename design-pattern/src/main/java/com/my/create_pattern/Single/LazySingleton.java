package com.my.create_pattern.Single;

public class LazySingleton {
    
    private static final LazySingleton lazySingleton=new LazySingleton();
    
    private LazySingleton() {
    }
    
    public static LazySingleton getInstance() {
        return lazySingleton;
    }
    
    public void doSomething() {
        System.out.println("do lazy something");
    }
}
