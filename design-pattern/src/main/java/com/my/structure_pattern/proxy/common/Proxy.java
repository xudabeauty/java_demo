package com.my.structure_pattern.proxy.common;

public class Proxy implements Subject {
    private Subject subject;
    public Proxy() {
        subject=new RealSubject();
    }
    public Proxy(Subject _sSubject) {
        this.subject=_sSubject;
    }
    
    public Proxy(Object...objects ) {
        
    }
    
    public void before() {
        System.out.println("before dosomething");
    }
    public void request() {
        before();
        subject.request();
        after();
    }
    public void after() {
        System.out.println("after dosomething");
    }
}
