package com.my.spring.myPoolDataSource;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        GPDataSource dataSource=new GPDataSource();
        Runnable runnable=()->{
          Connection connection=dataSource.getConn().getConnection();
          System.out.println(connection);
        };
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for(int i=0;i<60;i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

}
;;