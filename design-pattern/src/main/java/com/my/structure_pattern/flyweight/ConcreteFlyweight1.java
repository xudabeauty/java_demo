package com.my.structure_pattern.flyweight;

public class ConcreteFlyweight1 extends Flyweight{

    public ConcreteFlyweight1(String out) {
        super(out);
    }

    @Override
    public void operate() {
        System.out.println("do something");
    }

}
