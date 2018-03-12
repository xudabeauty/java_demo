package com.my.behavior_pattern.memento;

public class Caretaker {
    private IMemento iMemento;

    public IMemento getiMemento() {
        return iMemento;
    }

    public void setiMemento(IMemento iMemento) {
        this.iMemento = iMemento;
    }

}
