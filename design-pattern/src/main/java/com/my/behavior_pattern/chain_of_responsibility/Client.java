package com.my.behavior_pattern.chain_of_responsibility;

public class Client {
    public static void main(String[] args) {
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
        Handler handler3=new ConcreteHandler3();
        Request request=new Request();
        handler1.setNext(handler2);
        handler1.setNext(handler3);
        handler1.handlerMessage(request);
        
    }

}
