package com.my.spring.threadpool.myThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MAX_WORKER_NUMBER=10;
    private static final int DEFAULT_WORKER_NUMBER=5;
    private static final int MIN_WORKER_NUMBER=1;
    private final LinkedList<Job>jobs=new LinkedList<Job>();
    private final List<Worker>workers=Collections.synchronizedList(new  ArrayList<Worker>());
    private int workerNum;
    private AtomicLong threadNum=new AtomicLong();

    public DefaultThreadPool() {
        this.workerNum=DEFAULT_WORKER_NUMBER;
        initializeWorkers(workerNum);
    }
    public DefaultThreadPool(int num) {
        if(num>MAX_WORKER_NUMBER) {
            this.workerNum=MAX_WORKER_NUMBER;
        }else {
            this.workerNum=num;
        }
        initializeWorkers(workerNum);
    }
    private void initializeWorkers(int workerNum2) {
        for(int i=0;i<workerNum2;i++) {
            Worker worker=new Worker();
            workers.add(worker);
            Thread thread=new Thread(worker);
            thread.start();
        }
        
    }
    public void execute(Job job) {
        if(job!=null) {
            synchronized (jobs) {
             jobs.addLast(job); 
             jobs.notify();
            }
        }
    }

    public void shutdown() {
        for(Worker w:workers) {
            w.shutdown();
        }
    }

    public void addWrokers(int num) {
      synchronized (jobs) {
        if(num+this.workerNum<MAX_WORKER_NUMBER) {
            num=MAX_WORKER_NUMBER-this.workerNum;
        }
        initializeWorkers(num);
        workerNum+=num;
    }
    }

    public void remveWorkers(int num) {
        synchronized (jobs) {
            if(num>this.workerNum) {
                throw new IllegalArgumentException("超过了已有的线程数量");
            }
            for(int i=0;i<num;i++) {
                Worker worker=workers.get(i);
                worker.shutdown();
                workers.remove(i);
            }
            this.workerNum-=num;
            
        }
    }

    public int getJobSize() {
        return workerNum;
    }
    
    class Worker implements Runnable{
        private volatile boolean running=true;

        public void run() {
            while(running) {
                Job job=null;
                synchronized (jobs) {
                    if(jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                   job= jobs.removeFirst();
                }
                if(job!=null) {
                    job.run();
                }
                
            }
        }
        
        public void shutdown() {
            running=false;
        }
        
    }
    

}
