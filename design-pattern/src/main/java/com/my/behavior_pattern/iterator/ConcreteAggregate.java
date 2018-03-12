package com.my.behavior_pattern.iterator;

import java.util.Vector;

public class ConcreteAggregate extends Aggregate {

    private Vector<Object> vector=new Vector<Object>();
    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object obj) {
        this.vector.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(this.vector);
    }

}
