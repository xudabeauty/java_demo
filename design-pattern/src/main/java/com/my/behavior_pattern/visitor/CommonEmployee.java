package com.my.behavior_pattern.visitor;

public class CommonEmployee  extends Employee{
    private String job;
    

    public String getJob() {
        return job;
    }


    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public void accept(IVisitor visotor) {
        visotor.visit(this);      
    }

}
