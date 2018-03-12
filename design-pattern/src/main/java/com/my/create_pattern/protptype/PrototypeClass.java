package com.my.create_pattern.protptype;

public class PrototypeClass implements Cloneable {
    @Override
    public PrototypeClass clone() {
        PrototypeClass prototypeClass=null;
        try {
            prototypeClass=(PrototypeClass)super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return prototypeClass;
    }
}
