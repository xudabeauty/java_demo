package com.my.create_pattern.abstract_factory.example1;

public class ConcretCreator2 extends Createor {

    @Override
    public ProductA createA() {
        return new ConcretProductA2();
    }

    @Override
    public ProductB createB() {
        return new ConcretProductB2();
    }

}
