package com.my.handwrite.threadpool;

public interface ThreadPool <Job extends Runnable>{
    public void executor(Job job);
    public void shutdown();
    public void addWorker(int num);
    public void removeWorker(int num);
}
