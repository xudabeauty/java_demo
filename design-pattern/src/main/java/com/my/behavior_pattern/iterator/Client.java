package com.my.behavior_pattern.iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate aggregate=new ConcreteAggregate();
        String aString="aaa";
        String bString="bbb";
        String cString="ccc";
        aggregate.add(aString);
        aggregate.add(bString);
        aggregate.add(cString);
        Iterator iterator=aggregate.getIterator();
        while(iterator.hasNext()) {
           Object object= iterator.next();
           System.out.println(object);
        }
    }

}
