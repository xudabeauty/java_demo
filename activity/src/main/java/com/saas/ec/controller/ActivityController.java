package com.saas.ec.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(@RequestBody String json){
        LOGGER.info("接受参数:{}",json);
        ActivityEntity activityEntity = JSONObject.parseObject(json, ActivityEntity.class);
        activityService.saveActivity(activityEntity);
        return "success";
    }


}
