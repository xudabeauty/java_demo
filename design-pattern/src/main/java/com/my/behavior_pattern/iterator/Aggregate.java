package com.my.behavior_pattern.iterator;

public abstract class Aggregate {
    public abstract void add(Object object);
    public abstract void  remove(Object object);
    public abstract Iterator getIterator();

}
