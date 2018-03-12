package com.my.create_pattern.protptype;

public class Client {
    public static void main(String[] args) {
         PrototypeClass prototypeClass=new PrototypeClass();
         PrototypeClass prototypeCopy=prototypeClass.clone();
         System.out.println(prototypeClass);
         System.out.println(prototypeCopy);
         System.out.println(prototypeClass==prototypeCopy);
    }

}
