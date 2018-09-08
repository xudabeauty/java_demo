package com.saas.ec;

import static org.junit.Assert.assertTrue;

import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.mapper.ActivityMapper;
import com.saas.ec.model.ActivityParamVo;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.sun.org.apache.bcel.internal.generic.NEW;
import junit.extensions.ActiveTestSuite;
import org.apache.ibatis.mapping.ParameterMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AppTest

{
    //@Autowired
  ActivityMapper activityMapper;

    public void test(){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setTitle("testTitile");
        activityEntity.setStartTime(new Date());
        activityEntity.setEndTime(new Date());
        Integer integer = activityMapper.saveActivity(activityEntity);
        assertTrue(integer != null);
    }

    public void testSelect(){

        ActivityParamVo paramVo = new ActivityParamVo();
        paramVo.setMinId(0l);
        paramVo.setLimitNum(10);
        List<ActivityEntity> activityEntityList = activityMapper.selectActiveActivity(paramVo);
        System.out.println(activityEntityList);
    }

    //@Test
    public void testUpdate(){
        ActivityParamVo paramVo = new ActivityParamVo();
        paramVo.setMinId(0l);
        paramVo.setLimitNum(10);
        List<ActivityEntity> activityEntityList = activityMapper.selectActiveActivity(paramVo);
        System.out.println(activityEntityList);
        paramVo.setActivityParamVoList(activityEntityList);

        Integer integer = activityMapper.updateActivity(paramVo);

        assertTrue(integer!=null && integer == 1);

    };

@Test
    public void testUtl(){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        List list1 = new ArrayList();
        list1.add(3);
        list1.add(1);
//        list1.add(3);
        if (list.containsAll(list1))
            System.out.println("true");
    }
}
