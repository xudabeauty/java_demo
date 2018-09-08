package com.saas.ec.quartz;

import com.saas.ec.service.ActivityService;
import com.saas.ec.thread.ExpireActivityThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@Configuration
public class ExpireTask {

    private static final Logger logger = LoggerFactory.getLogger(ExpireTask.class);

    private Integer limitNum = 2;

    private Integer taskSwitch = 0;

    private  String localIp = "127.0.0.1";

    private AtomicBoolean isExpireTaskRunning = new AtomicBoolean(false);

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @Autowired
    private ActivityService activityService;

    public void expireActivityTask() throws UnknownHostException, InterruptedException {
        if (taskSwitch != 0){
            System.out.println("switch is off");
            return;
        }

        if (InetAddress.getLocalHost().equals(localIp)){
            return;
        }

        if (isExpireTaskRunning.compareAndSet(false,true)) {

            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                threadPoolTaskExecutor.execute(new ExpireActivityThread(limitNum, activityService, countDownLatch));
                countDownLatch.await();

            } catch (Exception e) {
                System.out.println("expireActivityTask error");
                logger.error("expireActivityTask error", e);

            } finally {
                isExpireTaskRunning.compareAndSet(true, false);
            }

        }else {
            System.out.println("expireActivityTask run with conflict, because last expireActivityTask is running");

        }



    }
}
