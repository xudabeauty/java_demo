package com.xu.mybatis.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {
    private MySqlSession sqlsession;
    private Class<T>clazz;

    
    public MapperProxy(MySqlSession session,Class<T>clazz) {
      this.sqlsession=session;
      this.clazz=clazz;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(MapperXml.namespace)) {
            String sql = MapperXml.map.get(method.getName());
            return sqlsession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }

}
