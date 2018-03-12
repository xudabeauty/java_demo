package com.my.behavior_pattern.memento;

public class Client {
    public static void main(String[] args) {
        Caretaker caretaker=new Caretaker();
        Originator originator=new Originator();
        caretaker.setiMemento(originator.createMemento());
        originator.restore(caretaker.getiMemento());
        
    }

}
