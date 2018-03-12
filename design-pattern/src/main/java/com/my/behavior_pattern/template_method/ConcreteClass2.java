package com.my.behavior_pattern.template_method;

public class ConcreteClass2 extends AbstractClass {

    @Override
    public void doSomething() {
        System.out.println("class2 do something");
    }

    @Override
    public void doAnything() {
        System.out.println("class2 do anything");
    }
}
