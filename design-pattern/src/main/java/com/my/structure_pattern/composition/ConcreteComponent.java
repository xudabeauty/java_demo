package com.my.structure_pattern.composition;

public class ConcreteComponent  extends AbstractComponent{

    public ConcreteComponent(String str) {
        super(str);
    }

    @Override
    public void dosomething() {
        System.out.println(super.getProperty());
    }

}
