package com.my.handwrite.mybatis.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProcxy implements InvocationHandler{
    private SqlSession sesssion;
    private Class clazz;

    public MapperProcxy(SqlSession sesssion, Class clazz) {
        this.sesssion = sesssion;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(TestMapperXml.NAME_SPACE)) {
            String sql=TestMapperXml.map.get(method.getName());
            return sesssion.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }

}
