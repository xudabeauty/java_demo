package com.my.structure_pattern.decorator;

public abstract class Decorator extends Component {
    private Component component=null;
    public Decorator(Component _component) {
        this.component=_component;
    }
    
    @Override
    public void  dosomething() {
        this.component.dosomething();
    }
}
