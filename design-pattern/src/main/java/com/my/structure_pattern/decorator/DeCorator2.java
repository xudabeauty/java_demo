package com.my.structure_pattern.decorator;

public class DeCorator2 extends Decorator{

    public DeCorator2(Component component) {
        super(component);
    }
    
    private void method2() {
        System.out.println("do methods2");
    }
    @Override
    public void dosomething() {
       this.method2();
       super.dosomething();
    }
}
