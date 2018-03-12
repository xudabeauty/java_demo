package com.my.behavior_pattern.visitor;

public interface IVisitor {

    public void visit(CommonEmployee employee);
    public void visit(Manage manage);

}
