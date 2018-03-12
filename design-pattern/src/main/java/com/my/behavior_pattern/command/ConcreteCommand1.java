package com.my.behavior_pattern.command;

public class ConcreteCommand1  extends Command{

    public ConcreteCommand1() {
        super(new ConcreteReceiver1());
    }
    public ConcreteCommand1(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void exec() {
        super.receiver.doSomething();
    }
    

}
