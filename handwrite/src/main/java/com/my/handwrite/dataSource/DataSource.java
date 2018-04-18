package com.my.handwrite.dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class DataSource {
    private Config config=new Config();
    private Vector<Connection> freePool=new Vector<>();
    private Vector<DataSourceEntry> usePool=new Vector<>();
    private AtomicInteger currentActive=new AtomicInteger(0);
    public DataSource() {
        init();
    }
    public void init() {
        for (int i = 0; i < Integer.parseInt(config.getInitSize()); i++) {
            createConn();
        }
        check();
    }
    
    public synchronized Connection createConn() {
        Connection connection=null;
        try {
            Class.forName(config.getDriver());
            connection=DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
            freePool.add(connection);
            currentActive.incrementAndGet();
            System.out.println("创建了一个新连接，当前连接的数是："+currentActive.get()+connection);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return connection;
    }
    
    public synchronized DataSourceEntry getConn() {
        Connection connection=null;
        if(!freePool.isEmpty()) {
            connection=freePool.remove(0);
        }else {
            if(currentActive.get()<Integer.parseInt(config.getMaxSize())) {
                connection=createConn();
            }else {
                System.out.println("线程已满，请等待");
                try {
                    wait(3000);
                    return getConn();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        }
        DataSourceEntry entry = new DataSourceEntry(connection, System.currentTimeMillis());
        usePool.add(entry);
        return entry;
    }
    
    public synchronized void release(Connection connection) {
        try {
            if(connection!=null&&!connection.isClosed()) {
                freePool.add(connection);
                System.out.println("回收了一个连接，当前的空闲连接数是:"+freePool.size());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private void check() {
        if(Boolean.parseBoolean(config.getHealth())) {
            Worker worker=new Worker();
            new Timer().schedule(worker, Long.parseLong(config.getDelay()),Long.parseLong(config.getPeroid()));
        }
    }
    
    class Worker extends TimerTask{
        @Override
        public void run() {
            System.out.println("例行检查");
            for (int i = 0; i < usePool.size(); i++) {
                long peroidTime=System.currentTimeMillis()-usePool.get(i).getCurrentTime();
                if(peroidTime>Long.parseLong(config.getTimeout())) {
                    Connection conn = usePool.get(i).getConnection();
                    try {
                        if(conn!=null&&!conn.isClosed()) {
                            conn.close();
                            usePool.remove(i);
                            currentActive.decrementAndGet();
                            System.out.println("发现有超时连接,强行关闭，当前连接数是"+currentActive.get());
                        }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                }
                
            }
        }
        
    }
}
