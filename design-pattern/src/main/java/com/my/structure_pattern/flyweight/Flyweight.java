package com.my.structure_pattern.flyweight;

public  abstract class Flyweight {
    //内部状态
    private String instate;
    //外部状态
    protected final String outstate;
    
    public Flyweight(String out) {
        this.outstate=out;
    }
    
    public abstract void operate();
    public String getInstate() {
        return instate;
    }
    public void setInstate(String instate) {
        this.instate = instate;
    }
    
}
