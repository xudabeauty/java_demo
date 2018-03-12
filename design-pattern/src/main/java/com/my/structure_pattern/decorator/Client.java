package com.my.structure_pattern.decorator;

public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        //第一次修饰
       component= new Decorator1(component);

        //第二次修饰
        component = new DeCorator2(component);

        //修饰后运行
        component.dosomething();
    }

}
