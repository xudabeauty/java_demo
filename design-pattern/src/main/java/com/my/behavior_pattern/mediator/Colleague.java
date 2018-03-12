package com.my.behavior_pattern.mediator;

public  abstract class Colleague {
    protected Meditor meditor;
    public Colleague(Meditor _mMeditor) {
        this.meditor=_mMeditor;
    }
    

}
