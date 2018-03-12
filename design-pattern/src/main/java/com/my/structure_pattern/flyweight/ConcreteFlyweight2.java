package com.my.structure_pattern.flyweight;

public class ConcreteFlyweight2  extends Flyweight{

    public ConcreteFlyweight2(String out) {
        super(out);
    }

    @Override
    public void operate() {
        System.out.println("do anything");
    }

}
