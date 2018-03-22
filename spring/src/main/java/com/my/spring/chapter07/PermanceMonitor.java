package com.my.spring.chapter07;

public class PermanceMonitor {
    
    private static ThreadLocal<MethodPermance> permanceRecord=new ThreadLocal<MethodPermance>();
    
    public static void begin(String method) {
        System.out.println("begin monitor");
        MethodPermance permance=new MethodPermance(method);
        permanceRecord.set(permance);
    }
    
    public static void end() {
        System.out.println("end monitor");
        MethodPermance permance=permanceRecord.get();
        permance.pringPermance();
    }

}
