package com.saas.ec.service;

import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.model.ActivityParamVo;

import java.util.List;

public interface ActivityService {

    Integer saveActivity(ActivityEntity activityEntity);

    List<ActivityEntity> queryActiveActivity(ActivityParamVo paramVo);

    Integer updateActivity(ActivityParamVo paramVo);
}
