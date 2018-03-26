package com.my.mvc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.mvc.annoation.MyController;
import com.my.mvc.annoation.MyRequestMapping;

public class MyDispacherServlet extends HttpServlet {
    /**  */
    private static final long serialVersionUID = 1L;
    private Properties properties=new Properties();
    private List<String>classNames=new ArrayList<>();
    private Map<String, Object>ioc=new HashMap<>();
    private Map<String, Method> handlerMapping=new HashMap<>();
    private Map<String, Object> controllerMap=new HashMap<>();
 
    @Override
    public void init(ServletConfig config) {
        //加载配置文件
        try {
            doLoadConfig(config.getInitParameter("contextConfigLocation"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化所有相关联的类，扫描用户设定的包下面所有得类
        doScanner(properties.getProperty("scanPackage"));
        //nadao扫描到的类，通过反射机制，实例化，并且反倒ioc容器中(k-v beanName-bean) beanName默认是首字母小写
        doInstance();
        //初始化HandlerMapping(将url和method对应上)
        initHandlerMapping();
    }
    
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            doDispatch(request,response);
        } catch (Exception e) {
            response.getWriter().write("500! server Exception");
        }
    }
    
    private void doDispatch(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(this.handlerMapping.isEmpty()) return;
        String url=request.getRequestURI();
        String contextPath=request.getContextPath();
        url=url.replace(contextPath, "").replaceAll("/+", "/");
        //handlerMapping中不存在请求url，返回404
        if(!this.handlerMapping.containsKey(url)) {
            response.getWriter().write("404 not found!");
            return;
        }
        
       Method method = this.handlerMapping.get(url);
       //获取方法的参数列表
       Class<?>[] parameterTypes = method.getParameterTypes();
       //获取请求的参数列表
       Map<String, String[]> parameterMap = request.getParameterMap();
       //保存参数值
      Object []paramValues= new Object[parameterTypes.length];
      for (int i = 0; i < parameterTypes.length; i++) {
        String requestParam=parameterTypes[i].getSimpleName();
        if(requestParam.equals("HttpServletRequest")) {
            paramValues[i]=request;
            continue;
        }
        if(requestParam.equals("HttpServletResponse")) {
            paramValues[i]=response;
            continue;
        }
        
        if(requestParam.equals("String")) {
            for (Entry<String, String[]> entry : parameterMap.entrySet()) {
                String value =Arrays.toString(entry.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
                paramValues[i]=value;
            }
        }
    }
      try {
        method.invoke(this.controllerMap.get(url), paramValues);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        e.printStackTrace();
    }
    }
    
    
    //将配置文件加载到properties
    private void doLoadConfig(String location) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
            if(null!=resourceAsStream) {
                resourceAsStream.close();
            }
        }
    }
    //将scanPackage中的类添加到className
    private void doScanner(String packageName) {
        URL url  =this.getClass().getClassLoader().getResource("/"+packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
        if(file.isDirectory()){
        //递归读取包
        doScanner(packageName+"."+file.getName());
        }else{
        String className =packageName +"." +file.getName().replace(".class", "");
        classNames.add(className);
        }
        }
    }
    
    //将标注了MyController注解的类实例化对象添加到ioc容器
    private void doInstance() {
        if(classNames.isEmpty()) return;
        for (String className : classNames) {
            try {
                Class<?> clazz=Class.forName(className);
                if(clazz.isAnnotationPresent(MyController.class)) {
                    ioc.put(toLowerFirstWord(clazz.getSimpleName()),clazz.newInstance());
                }else {
                    continue;
                }
            }catch (Exception e) {
              e.printStackTrace();
              continue;
            }
        }
    }
    /**
     * 将url添加
     */
    private void initHandlerMapping() {
        if(ioc.isEmpty()) return;
        try {
            for (Entry<String, Object> entry : ioc.entrySet()) {
                Class<?extends Object> clazz=entry.getValue().getClass();
                if(!clazz.isAnnotationPresent(MyController.class)) {
                    continue;
                }
                String baseUrl="";
                if(clazz.isAnnotationPresent(MyRequestMapping.class)) {
                    MyRequestMapping annotaion=clazz.getAnnotation(MyRequestMapping.class);
                    baseUrl=annotaion.value();
                }
                Method []methods=clazz.getMethods();
                for (Method method : methods) {
                    if(!method.isAnnotationPresent(MyRequestMapping.class)) {
                        continue;
                    }
                    MyRequestMapping requestAnnotation=method.getAnnotation(MyRequestMapping.class);
                    String url=requestAnnotation.value();
                    url=(baseUrl+"/"+url).replaceAll("/+", "/");
                    handlerMapping.put(url, method);
                    controllerMap.put(url, clazz.newInstance());
                    System.out.println(url+","+method);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String toLowerFirstWord(String src) {
        char charArray[]=src.toCharArray();
        charArray[0]+=32;
        return new String(charArray);
    }
}
