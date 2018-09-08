package com.saas.ec.handler.process;

import com.saas.ec.handler.model.AbstractRequest;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.util.CollectionUtils;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum HandlerRegister {

    INSTANCE;
    private HandlerRegister(){

    }

    private static Map<Class<? extends AbstractRequest>,Set<Handler>> REGISTER_CENTER = new ConcurrentHashMap<>();

    private Lock lock = new ReentrantLock();

    public Set<Handler> getType(Class<? extends AbstractRequest> requeset){
        return REGISTER_CENTER.get(requeset);
    }
    
    public void register(Handler handler,Class<? extends AbstractRequest> request){
        Set<Handler> handlers = REGISTER_CENTER.get(request);

        try {
            if (lock.tryLock()){
                if (!CollectionUtils.isEmpty(handlers)){
                   handlers = new HashSet<>();
                    REGISTER_CENTER.put(request,handlers);
                }

                handlers.add(handler);

            }
        }finally {
            lock.unlock();
        }
    }

    public void register(List<Class<?extends AbstractRequest>> requests,Handler handler){
        for (Class<? extends AbstractRequest> request: requests){
            register(handler,request);
        }
    }
}
