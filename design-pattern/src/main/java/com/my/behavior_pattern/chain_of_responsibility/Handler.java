package com.my.behavior_pattern.chain_of_responsibility;

public abstract  class Handler {
    private Handler next;
    public void setNext(Handler _hHandler) {
        this.next=_hHandler;
    }
    
    public Response handlerMessage(Request request) {
        Response response=null;
        if(this.getLevel().equals(request.getRequestRevel())) {
            
        }else {
            if(this.next!=null) {
                response=this.next.handlerMessage(request);
            }else {
                
            }
        }
        return response;
    }
    
    public abstract Level getLevel();
    public abstract void echo(Request request);

}
