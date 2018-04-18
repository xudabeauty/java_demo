package com.my.handwrite.mybatis;

public interface Executor {
    public <T> T query(String sql,String param);

}
