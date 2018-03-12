package com.my.behavior_pattern.template_method;

public class Client {
    public static void main(String[] args) {
        AbstractClass class1=new ConcreteClass1();
        AbstractClass class2=new ConcreteClass2();
        class1.templateMethod();
        String string="";
;        class2.templateMethod();
    }

}
