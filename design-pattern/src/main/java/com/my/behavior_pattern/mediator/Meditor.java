package com.my.behavior_pattern.mediator;

public  abstract class Meditor {
    protected ConcreteColleague1 colleague1;
    protected ConcreteColleague2 colleague2;
    public ConcreteColleague2 getColleague2() {
        return colleague2;
    }
    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }
    public ConcreteColleague1 getColleague1() {
        return colleague1;
    }
    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }
  
    
    public abstract void doSmothing();
    public abstract void doAnything();

}
