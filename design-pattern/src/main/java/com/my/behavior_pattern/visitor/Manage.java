package com.my.behavior_pattern.visitor;

public class Manage extends Employee{
    private String permance;

    public String getPermance() {
        return permance;
    }

    public void setPermance(String permance) {
        this.permance = permance;
    }

    @Override
    public void accept(IVisitor visotor) {
        visotor.visit(this);
    }
}
