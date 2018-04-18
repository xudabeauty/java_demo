package com.my.handwrite.dataSource;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;




public class Config {
    private String driver;
     private String url;
     private String username;
     private String password;
     private String initSize;
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
    private String maxSize;
     private String health;
     private String delay;
     private String peroid;
     private String timeout;
     
     public Config() {
         InputStream config = this.getClass().getClassLoader().getResourceAsStream("com/my/handwrite/dataSource/db.properties");
         Properties props=new Properties();
         try {
            props.load(config);
            for (Object prop : props.keySet()) {
                String key = ((String)prop).replace("jdbc.", "");
                String value=(String) props.get(prop);
               Field field = this.getClass().getDeclaredField(key);
               Method method = this.getClass().getMethod("set"+toUpper(key), field.getType());
               method.invoke(this, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     private String toUpper(String src) {
         char[] charArray = src.toCharArray();
         charArray[0]-=32;
         return new String(charArray);
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

    public String getPeroid() {
        return peroid;
    }

    public void setPeroid(String peroid) {
        this.peroid = peroid;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "Config [driver=" + driver + ", url=" + url + ", username=" + username + ", password=" + password + ", initSize=" + initSize + ", maxSize=" + maxSize + ", health="
               + health + ", delay=" + delay + ", peroid=" + peroid + ", timeout=" + timeout + "]";
    }

    public static void main(String[] args) {
        System.out.println(new Config().toString());
    }
}
