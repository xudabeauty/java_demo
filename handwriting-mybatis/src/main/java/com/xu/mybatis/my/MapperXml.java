package com.xu.mybatis.my;

import java.util.HashMap;
import java.util.Map;

public class MapperXml {

    public static final String namespace="com.xu.mybatis.my.TestMapper";
    public static Map<String, String>map=new HashMap<>();
    static {
        map.put("getByPrimaryId", "select * from test where id = %d");
    }
}
