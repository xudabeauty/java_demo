package com.saas.ec.handler.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractRequest {

   public String currentActivityType(){
        return StringUtils.EMPTY;
    }
}
