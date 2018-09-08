package com.saas.ec.mapper;

import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.model.ActivityParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.util.List;
@Mapper
public interface ActivityMapper {
    public Integer saveActivity(ActivityEntity entity);

    public List<ActivityEntity> selectActiveActivity(ActivityParamVo entity);

    public Integer updateActivity(ActivityParamVo entity);
}
