package com.my.handwrite.dataSource;

import java.sql.Connection;

public class DataSourceEntry {
    private Connection connection;
    private long currentTime;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public long getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
    public DataSourceEntry(Connection connection, long currentTime) {
        this.connection = connection;
        this.currentTime = currentTime;
    }
}
