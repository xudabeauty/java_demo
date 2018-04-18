package com.my.handwrite.mybatis.mapper;

import java.lang.reflect.Proxy;

import com.my.handwrite.mybatis.DefaultExecutor;
import com.my.handwrite.mybatis.Executor;

public class SqlSession {
    Executor executor=new DefaultExecutor();
    
    public <T> T selectOne(String sql,String param) {
        return executor.query(sql, param);
    }
    
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[] {clazz}, new MapperProcxy(this,clazz));
    }
    
}
