package com.my.behavior_pattern.mediator;

public class ConcreteColleague1 extends Colleague{

    public ConcreteColleague1(Meditor _mMeditor) {
        super(_mMeditor);
    }
    public void selfMethod() {
        
    }
    public void depMethod() {
        super.meditor.doSmothing();
        
    }

}
