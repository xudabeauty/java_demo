package com.my.behavior_pattern.mediator;

public class ConcreteColleague2  extends Colleague{

    public ConcreteColleague2(Meditor _mMeditor) {
        super(_mMeditor);
    }
        
        public void selfMethod() {
            
        }
        public void depMethod() {
            super.meditor.doAnything();
            
        }

}
