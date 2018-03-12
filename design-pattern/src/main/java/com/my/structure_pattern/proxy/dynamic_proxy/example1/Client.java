package com.my.structure_pattern.proxy.dynamic_proxy.example1;

public class Client {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy(new RealSubject());
        String[] arg= { "do something" };
        proxy.exec("doSomething", arg);
    }
}
