package com.my.create_pattern.Single;

public final class HungrySingleton {
    
    private static HungrySingleton hungrySingleton=null;
    
    private HungrySingleton() {
        
    }
    
    public  synchronized static  HungrySingleton getInstance() {
        if(hungrySingleton == null) {
            return new HungrySingleton();
        }
        return hungrySingleton;
    }
    
    public void doSomething() {
        System.out.println("do hungry something");
    }

}
