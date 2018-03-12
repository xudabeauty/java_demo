package com.my.create_pattern.factory_method;

public abstract class Factory {
    
    public abstract <T extends Product> T create(Class<T>product);

}
