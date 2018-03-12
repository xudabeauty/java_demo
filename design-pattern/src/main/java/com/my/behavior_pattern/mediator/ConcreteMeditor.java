package com.my.behavior_pattern.mediator;

public class ConcreteMeditor extends Meditor{

    @Override
    public void doSmothing() {
        super.colleague1.selfMethod();
        super.colleague2.selfMethod();
    }

    @Override
    public void doAnything() {
        super.colleague1.selfMethod();
        super.colleague2.selfMethod();
    }

}
