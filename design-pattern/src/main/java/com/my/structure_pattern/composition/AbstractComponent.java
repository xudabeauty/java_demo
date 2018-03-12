package com.my.structure_pattern.composition;

public abstract class AbstractComponent {
    private String property;
    public AbstractComponent(String str) {
        this.property=str;
    }
    public String getProperty() {
        return this.property;
    }
    public abstract void dosomething();
    

}
