package com.my.spring.chapter07;

public class MethodPermance {
    
    private long begin;
    private long end;
    private String serviceMetod;
    public MethodPermance(String serviceMethod) {
        this.serviceMetod=serviceMethod;
        this.begin=System.currentTimeMillis();
    }
    public void pringPermance() {
        end=System.currentTimeMillis();
        long elapse=end-begin;
        System.out.println(serviceMetod+"花费"+elapse+"毫秒。");
    }

}
