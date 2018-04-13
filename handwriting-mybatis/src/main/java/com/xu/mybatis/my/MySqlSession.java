package com.xu.mybatis.my;

import java.lang.reflect.Proxy;

public class MySqlSession {
Executor executor=new SimpleExecutor();
public <T> T selectOne(String sql,String param) {
    return executor.query(sql, param);
}

public <T> T getMapper(Class<T> clazz) {
    return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[] {clazz} , new MapperProxy<>(this, clazz));
}
}
