package com.my.behavior_pattern.command;

public class ConcreteCommand2 extends Command{

    public ConcreteCommand2() {
        super(new ConcreteReceiver2());
    }
    public ConcreteCommand2(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void exec() {
        super.receiver.doSomething();
    }

}
