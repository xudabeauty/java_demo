package com.saas.ec.Configuration;

import com.saas.ec.quartz.ExpireTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setKeepAliveSeconds(300);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10000);
        return executor;
    }

    @Bean
   public ExpireTask expireTask(){
       ExpireTask expireTask = new ExpireTask();
       return expireTask;
   }

   @Bean
   public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(ExpireTask expireTask) {
       MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();

       bean.setTargetObject(expireTask);

       bean.setTargetMethod("expireActivityTask");

       return  bean;

   }

   @Bean
   public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail methodInvokingJobDetailFactoryBean){
       CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
       bean.setJobDetail(methodInvokingJobDetailFactoryBean);
       bean.setCronExpression("0 0/2 * * * ?");
       return bean;
   }

   @Bean
   public SchedulerFactoryBean schedulerFactoryBean(Trigger cronTriggerFactoryBean){
       SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
       schedulerFactoryBean.setTriggers(cronTriggerFactoryBean);
       return schedulerFactoryBean;
   }





}
