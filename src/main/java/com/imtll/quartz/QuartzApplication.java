package com.imtll.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) throws SchedulerException, InterruptedException, SchedulerException {

        SpringApplication.run(QuartzApplication.class, args);

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        System.out.println("scheduler.start");

        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class).withIdentity("job1","group1").build();
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();

        scheduler.scheduleJob(jobDetail,trigger);

        TimeUnit.SECONDS.sleep(20);

        /*scheduler.shutdown();//关闭定时任务调度器.

        System.out.println("scheduler.shutdown");*/
    }

}
