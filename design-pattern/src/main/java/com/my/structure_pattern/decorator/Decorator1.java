package com.my.structure_pattern.decorator;

public class Decorator1 extends Decorator {

    public Decorator1(Component component) {
        super(component);
    }
    
    private void method1() {
        System.out.println("do methods1");
    }
    
    @Override
    public void dosomething() {
        super.dosomething();
        this.method1();
    }
}
