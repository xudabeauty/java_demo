package com.my.spring.myPoolDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class GPDataSource {

    GPConfig                          config        = new GPConfig();

    //当前活跃的连接数
    private AtomicInteger             currentActive = new AtomicInteger(0);

    //空闲的连接池
    private Vector<Connection>        freePool      = new Vector<>();

    private Vector<GPDataSourceEntry> usePool       = new Vector<>();

    public GPDataSource() {
        init();
    }

    public void init() {
        for (int i = 0; i < Integer.valueOf(config.getInitSize()); i++) {
            Connection connection = createConn();
            freePool.add(connection);
        }
        check();
    }

    public synchronized Connection createConn() {
        Connection connection = null;

        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            currentActive.getAndIncrement();
            System.out.println("创建一个新的连接，当前的连接数是：" + currentActive.get() + " connection:" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public synchronized GPDataSourceEntry getConn() {
        Connection connection = null;
        if (!freePool.isEmpty()) {
            connection = freePool.remove(0);
        } else if (currentActive.get() < Integer.valueOf(config.getMaxSize())) {
            connection = createConn();
        } else {
            System.out.println("数据库连接池已满，请等待.............");
            try {
                wait(1000);
                return getConn();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        GPDataSourceEntry entry = new GPDataSourceEntry(connection, System.currentTimeMillis());
        usePool.add(entry);
        return entry;
    }

    public synchronized void release(Connection connection) {
        try {

            if (connection != null && !connection.isClosed()) {
                freePool.add(connection);
                System.out.println("回收了一个连接，当前连接数是：" + freePool.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check() {
        if (Boolean.valueOf(config.getHealth())) {
            Worker worker = new Worker();
            new Timer().schedule(worker, Long.valueOf(config.getDelay()), Long.valueOf(config.getPeriod()));
        }

    }

    class Worker extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("例行检查");
                for (int i = 0; i < usePool.size(); i++) {
                    GPDataSourceEntry entry = usePool.get(i);
                    long startTime = entry.getStartTime();
                    long currentTime = System.currentTimeMillis();
                    if ((currentTime - startTime) > Long.valueOf(config.getTimeout())) {
                        Connection connection = entry.getConnection();
                        connection.close();
                        usePool.remove(i);
                        currentActive.decrementAndGet();
                        System.out.println("发现有超时连接，移除，当前活动的连接数：" + currentActive.get());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
