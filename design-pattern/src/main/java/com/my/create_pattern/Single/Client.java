package com.my.create_pattern.Single;

public class Client {
    public static void main(String[] args) {
        LazySingleton lazySingletonA=LazySingleton.getInstance();
        LazySingleton lazySingletonB=LazySingleton.getInstance();
        lazySingletonA.doSomething();
        lazySingletonB.doSomething();
        System.out.println(lazySingletonA==lazySingletonB);
        
        HungrySingleton hungrySingletonX=HungrySingleton.getInstance();
        HungrySingleton hungrySingletonY=HungrySingleton.getInstance();
        hungrySingletonX.doSomething();
        hungrySingletonY.doSomething();
        System.out.println(hungrySingletonX==hungrySingletonY);
                
    }

}
