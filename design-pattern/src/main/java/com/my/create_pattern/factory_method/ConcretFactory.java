package com.my.create_pattern.factory_method;

public class ConcretFactory extends Factory{

    @Override
    public <T extends Product> T create(Class<T> product) {
        Product p=null;
        try {
            p=(T)Class.forName(product.getName()).newInstance();
            return (T)Class.forName(product.getName()).newInstance();
        } catch (Exception e) {
        } 
        return (T)p;
    }

}
