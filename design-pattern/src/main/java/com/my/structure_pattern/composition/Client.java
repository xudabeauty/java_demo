package com.my.structure_pattern.composition;

public class Client {
    public static void main(String[] args) {
        AbstractComponent component=new ConcreteComponent("firstchild");
        AbstractComponent component2=new ConcreteComponent("secondchild");
        Composite composite=new Composite();
        composite.add(component);
        composite.add(component2);
        composite.remove(component);
        
    }

}
