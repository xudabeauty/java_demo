package com.my.spring.myPoolDataSource;

import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class GPConfig {
    private String driver;
    private String url;
    private String username;
    private String password;
    private String initSize;
    private String maxSize;
    private String health;
    private String delay;
    private String period;
    private String timeout;
    //根据反射初始化数据库配置
    public GPConfig() {
        try {
            Properties properties=new Properties();
            Resource resource=new ClassPathResource("com/my/spring/myPoolDataSource/db.properties");
            properties.load(resource.getInputStream());
            for(Object obj:properties.keySet()) {
                String fileName=obj.toString().replace("jdbc.", "");
                Method method=this.getClass().getMethod(transSetMethod(fileName), String.class);
                method.invoke(this, properties.get(obj));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //根据filedName获取set函数
    public String transSetMethod(String fieldName) {
        char []chars=fieldName.toCharArray();
        chars[0]-=32;
        return "set"+new String(chars);
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getInitSize() {
        return initSize;
    }
    public void setInitSize(String initSize) {
        this.initSize = initSize;
    }
    public String getMaxSize() {
        return maxSize;
    }
    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }
    public String getHealth() {
        return health;
    }
    public void setHealth(String health) {
        this.health = health;
    }
    public String getDelay() {
        return delay;
    }
    public void setDelay(String delay) {
        this.delay = delay;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getTimeout() {
        return timeout;
    }
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    
    public static void main(String[] args) {
        GPConfig config=new GPConfig();
        System.out.println(config.getDriver());
    }

}
