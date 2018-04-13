package com.my.spring.mythreadpool;

public interface MyThreadPool <Job extends Runnable>{
    public void execute(Job job);
    public void remove(int num);
    public void add(int num);
    public void shutdow();

}
