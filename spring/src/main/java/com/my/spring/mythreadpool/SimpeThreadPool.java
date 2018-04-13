package com.my.spring.mythreadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SimpeThreadPool<Job extends Runnable> implements MyThreadPool<Job> {
    private final int       MAX_WORKER_NUM     = 10;
    private final int       DEFAULT_WORKER_NUM = 5;
    private final int       MIN_WORKER_NUM     = 1;
    private LinkedList<Job> jobs               = new LinkedList<>();
    private List<Worker>    workers            =Collections.synchronizedList(new ArrayList<>());
    private int             workerNum;
    public SimpeThreadPool() {
        initWorker(DEFAULT_WORKER_NUM);
    }
    
    public SimpeThreadPool(int num) {
        if(num<=MAX_WORKER_NUM) {
            workerNum=num;
        }else {
            workerNum=DEFAULT_WORKER_NUM;
        }
        initWorker(workerNum);
    }
    private void initWorker(int num) {
        for(int  i=0;i<num;i++) {
               Worker worker = new Worker();  
               workers.add(worker);
               Thread thread=new Thread(worker);
               thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(null!=job) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void remove(int num) {
        if(num>workerNum) {
            throw new IllegalArgumentException("超过了已有线程的数量");
        }
        synchronized (jobs) {
            for(int i=0;i<num;i++) {
             Worker worker = workers.get(i);
             worker.shutdown();
             workers.remove(i);
            }
            workerNum-=num;
        }
    }

    @Override
    public void add(int num) {
        synchronized (jobs) {
            if(num<MAX_WORKER_NUM) {
                if(num+workerNum>MAX_WORKER_NUM) {
                    num=MAX_WORKER_NUM-workerNum;
                }
                initWorker(num);;
                workerNum+=num;
            }
        }
    }

    @Override
    public void shutdow() {
        for (Worker worker : workers) {
            worker.shutdown();
            workers.remove(worker);
            
        }
    }

    class Worker implements Runnable {
        private volatile boolean isRunning = true;

        @Override
        public void run() {
            while (isRunning) {
                Job job=null;
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                     job = jobs.removeFirst();
                }
                if (null != job) {
                    job.run();
                }
            }
        }

        public void shutdown() {
            isRunning = false;
        }
    }
}
