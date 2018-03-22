package com.my.spring.myPoolDataSource;

import java.sql.Connection;

public class GPDataSourceEntry {
    
    private Connection connection;
    private long startTime;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public GPDataSourceEntry(Connection connection, long startTime) {
        this.connection = connection;
        this.startTime = startTime;
    }
    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

}
