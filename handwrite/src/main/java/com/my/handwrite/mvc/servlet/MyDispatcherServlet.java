package com.my.handwrite.mvc.servlet;

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

import com.my.handwrite.mvc.annotation.MyController;
import com.my.handwrite.mvc.annotation.MyRequestMapping;

public class MyDispatcherServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private Properties          properties       = new Properties();
    private List<String>        classNames       = new ArrayList<>();
    private Map<String, Object> ioc              = new HashMap<>();
    private Map<String, Method> handlerMapping   = new HashMap<>();
    private Map<String, Object> controllerMap    = new HashMap<>();

    @Override
    public void init(ServletConfig config) {
        //加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //初始化所有相关联的类，扫描用户报下面所有的类
        doScanner(properties.getProperty("scanPackage"));

        //拿到扫描到的类，通过反射机制，实例化，并放到ioc容器中(k-v beanName-bean) beanName默认是首字母小写
        doInstance();

        //初始化HandlerMapping(将url和method对应上)
        initHandlerMapping();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500! server Exception");
        }
    }

    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (this.handlerMapping.isEmpty())
            return;
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!this.handlerMapping.containsKey(url)) {
            response.getWriter().write("404 not found!");
            return;
        }

        Method method = this.handlerMapping.get(url);
        //获取方法的参数列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        //获取请求的参数列表
        Map<String, String[]> parameterMap = request.getParameterMap();
        //保存参数值
        Object[] paramValues = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            String requestParam = parameterTypes[i].getSimpleName();
            if (requestParam.equals("HttpServletRequeset")) {
                paramValues[i] = request;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                paramValues[i] = response;
                continue;
            }
            if (request.equals("String")) {
                for (Entry<String, String[]> entry : parameterMap.entrySet()) {
                    String value = Arrays.toString(entry.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
                    paramValues[i] = value;
                }
            }
        }
        try {
            method.invoke(this.controllerMap.get(url), paramValues);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //将配置文件加载到properties中
    private void doLoadConfig(String location) {
        InputStream config = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            properties.load(config);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (config != null) {
                try {
                    config.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将scanPackage中的类添加到className
    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                //递归读取包
                doScanner(packageName + "." + file.getName());
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }

    //将标注了MyController注解的类实例化对象添加到ioc容器中
    private void doInstance() {
        if (classNames.isEmpty())
            return;
        for (String className : classNames) {
            Class<?> clazz;
            try {
                clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class)) {
                    ioc.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                } else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty())
            return;
        for (Entry<String, Object> entry : ioc.entrySet()) {
            Class<? extends Object> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                baseUrl = clazz.getAnnotation(MyRequestMapping.class).value();
            }
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(MyRequestMapping.class))
                    continue;
                String url = method.getAnnotation(MyRequestMapping.class).value();
                url = (baseUrl + "/" + url).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                try {
                    controllerMap.put(url, clazz.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(url + "," + method);
            }
        }
    }

    private String toLowerFirstWord(String src) {
        char charArray[] = src.toCharArray();
        charArray[0] += 32;
        return new String(charArray);
    }
}
