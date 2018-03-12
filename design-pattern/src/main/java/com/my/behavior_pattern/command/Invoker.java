package com.my.behavior_pattern.command;

public class Invoker {
    private Command command;
   public void setCommand(Command com) {
       command=com;
   }
   public void action() {
       this.command.exec();
   }

}
