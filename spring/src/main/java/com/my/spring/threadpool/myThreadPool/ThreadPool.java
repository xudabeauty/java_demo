package com.my.spring.threadpool.myThreadPool;

public interface ThreadPool <Job extends Runnable>{
    void execute(Job job);
    void shutdown();
    void addWrokers(int num);
    void remveWorkers(int num);
    int getJobSize();
   

}
