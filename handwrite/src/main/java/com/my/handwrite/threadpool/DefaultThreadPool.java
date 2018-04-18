package com.my.handwrite.threadpool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool <Job extends Runnable> implements ThreadPool<Job>{
    private final int MIN_WORKER=1;
    private final int DEFAULT_WORKER=5;
    private final int MAX_WORKER=10;
    private LinkedList<Job>jobs=new LinkedList<>();
    private List<Worker> workers=Collections.synchronizedList(new LinkedList<>());
    private AtomicInteger currentWorkers=new AtomicInteger(0);
    public DefaultThreadPool() {
        init(DEFAULT_WORKER);
    }
   public DefaultThreadPool(int num) {
       if(num>MAX_WORKER) {
           num=DEFAULT_WORKER;
       }
       init(num);
   }
    public void init(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker=new Worker();
            workers.add(worker);
            currentWorkers.incrementAndGet();
            new Thread(worker).start();
        }
    }
    
    @Override
    public void executor(Job job) {
        if(job!=null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(int i=0;i<workers.size();i++) {
            workers.get(i).shutdown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs) {
         if(num<MAX_WORKER) {
             if(num+currentWorkers.get()>MAX_WORKER) {
                 num=MAX_WORKER-currentWorkers.get();
             }
             init(num);
         }
        }
    }

    @Override
    public void removeWorker(int num) {
        if(num>MAX_WORKER) {
            throw new IllegalArgumentException("超过了已有线程数");
        }
        synchronized (jobs) {
            for(int i=0;i<num;i++) {
                Worker worker = workers.remove(i);
                worker.shutdown();
                currentWorkers.decrementAndGet();
            }
        }
    }
    
     class  Worker implements Runnable{
         private volatile boolean isRunning=true;

        @Override
        public void run() {
            while(isRunning) {
                Job job=null;
                synchronized (jobs) {
                    if(!jobs.isEmpty()) {
                        job = jobs.removeFirst();
                    }else {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                           Thread.currentThread().interrupt();
                           return;
                        }
                    }
                }
                if(job!=null) {
                    job.run();
                }
            }
        }
        public void shutdown() {
            isRunning=false;
        }
        
    }

}
