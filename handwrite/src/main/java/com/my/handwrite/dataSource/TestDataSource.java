package com.my.handwrite.dataSource;

import java.sql.Connection;

import com.my.handwrite.threadpool.DefaultThreadPool;
import com.my.handwrite.threadpool.ThreadPool;

public class TestDataSource {
    public static void main(String[] args) {
        DataSource dataSource=new DataSource();
        Runnable runnable=()->{
          Connection connection = dataSource.getConn().getConnection();  
        };
       // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ThreadPool<Runnable> threadPool=new DefaultThreadPool<>(5);
        for (int i = 0; i < 60; i++) {
            threadPool.executor(runnable);
        }
        threadPool.shutdown();
    }
}
