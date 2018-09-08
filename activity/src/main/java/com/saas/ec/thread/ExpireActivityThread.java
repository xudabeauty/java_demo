package com.saas.ec.thread;

import com.saas.ec.entity.ActivityEntity;
import com.saas.ec.model.ActivityParamVo;
import com.saas.ec.service.ActivityService;
import org.apache.ibatis.mapping.ParameterMap;
import org.junit.runner.Runner;
import org.slf4j.LoggerFactory;

import java.text.BreakIterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class ExpireActivityThread  implements Runnable{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ExpireActivityThread.class);

    public static final ThreadLocal<Long> minId = new ThreadLocal<>();

    private Integer limitNum;

    private ActivityService activityService;

    private CountDownLatch countDownLatch;

    public ExpireActivityThread(Integer limitNum, ActivityService activityService, CountDownLatch countDownLatch) {
        this.limitNum = limitNum;
        this.activityService = activityService;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
     try {
         while (true){
             if (minId.get() == null){
                 minId.set(0l);
             }
             long beginTime = System.currentTimeMillis();

             ActivityParamVo paramVo = new ActivityParamVo();
             paramVo.setLimitNum(limitNum);
             paramVo.setMinId(minId.get());
             List<ActivityEntity> activityEntityList = activityService.queryActiveActivity(paramVo);

             if (activityEntityList == null || activityEntityList.size() == 0){
                 long endTime = System.currentTimeMillis();
                 System.out.println(Thread.currentThread().getName()+" ExpireActivityThread process " +limitNum + "data"+" cost "+(endTime - beginTime) +"ms" );
                 break;
             }
             if (activityEntityList.size()< limitNum){
                 long endTime = System.currentTimeMillis();
                 long cost = endTime - beginTime;
                 System.out.println(Thread.currentThread().getName() + "-------"+ "ExpireActivityThread process  "+limitNum + " data," + "beginTime:" + beginTime + ",cost:" + cost + "ms");
                 break;
             }else {
                 minId.set(activityEntityList.get(activityEntityList.size()-1).getId());
             }

             long endTime = System.currentTimeMillis();
             long cost = endTime - beginTime;
             System.out.println(Thread.currentThread().getName() + "-------"+ "ExpireActivityThread process  "+limitNum + " data," + "beginTime:" + beginTime + ",cost:" + cost + "ms");
         }

     }catch (Exception e ){
         System.out.println("ExpireActivityThread error");
         logger.error("ExpireActivityThread error",e);

     }finally {
         countDownLatch.countDown();
     }
    }
}
