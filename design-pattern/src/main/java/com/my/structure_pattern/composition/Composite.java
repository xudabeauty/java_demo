package com.my.structure_pattern.composition;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    private List<AbstractComponent> list=new ArrayList<AbstractComponent>();
    
    public Integer getLen() {
        System.out.println("list len："+list.size());
        return list.size();
    }
    public void add(AbstractComponent component) {
        list.add(component);
        getLen();
    }
    
    public void remove(AbstractComponent component) {
        list.remove(component);
        getLen();
    }
    
    public List<AbstractComponent> getAllChildren(){
        return this.list;
    }
    
    

}
