package com.xu.mybatis.my;

public interface Executor {
    
    public <T> T query(String sql,String params);

}
