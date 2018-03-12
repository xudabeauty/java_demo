package com.my.behavior_pattern.iterator;

import java.util.Vector;

public class ConcreteIterator implements Iterator {
    private Vector<Object> vector=new Vector<Object>();
    private int curos;
    
    public ConcreteIterator(Vector< Object> vector) {
        this.vector=vector;
    }
    public boolean hasNext() {
        if(this.curos==vector.size())
            return false;
        return true;
    }

    public Object next() {
        Object object=null;
        if(hasNext()) {
             object=  vector.get(curos++);
        }else {
            return null;
        }
       return object;
    }

    public boolean remove() {
        vector.remove(curos);
        return true;
    }

}
