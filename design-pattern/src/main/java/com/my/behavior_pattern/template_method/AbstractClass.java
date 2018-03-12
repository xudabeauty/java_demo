package com.my.behavior_pattern.template_method;

public abstract class AbstractClass {
    public abstract void doSomething();
    public abstract void doAnything();
    public void templateMethod() {
        doSomething();
        doAnything();
    }

}
