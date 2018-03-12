package com.my.behavior_pattern.template_method;

public class ConcreteClass1  extends AbstractClass{

    @Override
    public void doSomething() {
        System.out.println("class1 do something");
    }

    @Override
    public void doAnything() {
        System.out.println("class1 do anything");
    }

}
