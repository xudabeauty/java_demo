package com.my.handwrite.mybatis.mapper;

import java.util.HashMap;
import java.util.Map;

public class TestMapperXml {
    public static final String NAME_SPACE="com.my.handwrite.mybatis.mapper.TestMapper";
    public static Map<String,String> map=new HashMap<>();
    static {
        map.put("selectById","select * from test where id= %d ");
    }
}
