package com.my.create_pattern.abstract_factory.example1;

public class Client {
    public static void main(String[] args) {
        Createor createor1=new ConcretCreator1();
        Createor creator2=new ConcretCreator2();
        ProductA productA1=createor1.createA();
        ProductB productB1=createor1.createB();
        ProductA productA2=creator2.createA();
        ProductB productB2=creator2.createB();
        productA1.doSometgingA();
        productA2.doSometgingA();
        productB1.doSomethingB();
        productB2.doSomethingB();
    }

}
