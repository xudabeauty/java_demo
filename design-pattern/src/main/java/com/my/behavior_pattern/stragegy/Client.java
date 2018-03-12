package com.my.behavior_pattern.stragegy;

public class Client {
public static void main(String[] args) {
    Strategy strategy=new Startegy1();
    Strategy strategy2 =new Strategy2();
    Context context=new Context(strategy);
    context.doAnything();
}
}
