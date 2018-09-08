package com.saas.ec.handler.process;

import com.saas.ec.handler.model.AbstractRequest;
import com.saas.ec.handler.model.DocRequest;

import java.util.Set;

public class HandlerDispatch {

    public void dispatch(AbstractRequest request){
        Set<Handler> handlers = HandlerRegister.INSTANCE.getType(request.getClass());
        for (Handler handler:handlers){
            if (adaptHandler(handler,request)){
                 ((ActivityHandler) handler).createDoc((DocRequest) request);
            }

        }

    }

    private boolean adaptHandler(Handler handler, AbstractRequest request){
       return (handler instanceof ActivityHandler) &&(((ActivityHandler) handler).getSupportEnum().equals(request.currentActivityType()));
    }
}
