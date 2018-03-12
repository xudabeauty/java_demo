package com.my.structure_pattern.flyweight;

import java.util.Hashtable;

public class FlyweightFactory {
    
    private static Hashtable< String, Flyweight> pool=new Hashtable<String, Flyweight>();
    
   public static Flyweight getInstance(String outstate) {
       if(pool.contains(outstate)) {
           return pool.get(outstate);
       }else {
           Flyweight flyweight=new ConcreteFlyweight1(outstate);
           pool.put(outstate, flyweight);
           return flyweight;
       }
   }

}
