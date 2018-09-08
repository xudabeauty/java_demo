package com.saas.ec.service.impl;

import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.mapper.ActivityMapper;
import com.saas.ec.model.ActivityParamVo;
import com.saas.ec.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Override
    public Integer saveActivity(ActivityEntity activityEntity) {
        return activityMapper.saveActivity(activityEntity);
    }

    @Override
    public List<ActivityEntity> queryActiveActivity(ActivityParamVo paramVo){
        return activityMapper.selectActiveActivity(paramVo);
    }

    @Override
    public  Integer updateActivity(ActivityParamVo paramVo){
        return activityMapper.updateActivity(paramVo);
    }
}
