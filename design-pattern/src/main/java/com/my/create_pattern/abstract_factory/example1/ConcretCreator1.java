package com.my.create_pattern.abstract_factory.example1;

public class ConcretCreator1 extends Createor {

    @Override
    public ProductA createA() {
        return new ConcretProductA1();
    }

    @Override
    public ProductB createB() {
        return new ConcretProductB1();
    }
}
