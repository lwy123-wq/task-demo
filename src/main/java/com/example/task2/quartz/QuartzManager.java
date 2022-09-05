package com.example.task2.quartz;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public class QuartzManager {
    private static QuartzManager quartzManager=new QuartzManager();
    public static QuartzManager getInstance(){
        return quartzManager;
    }
    @Autowired
    private Scheduler scheduler;

    private QuartzManager() {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException("构造调度任务异常...", e);
        }
    }
    public void addJob(String name, String group, Class<? extends JobContext> clazz, String expression, Map<String,?> jdbDataMap) throws SchedulerException {
        JobDetail job= JobBuilder.newJob(clazz).withIdentity(name,group).storeDurably().build();
        if(MapUtils.isNotEmpty(jdbDataMap))
            job.getJobDataMap().putAll(jdbDataMap);
        //触发器
        Trigger trg = TriggerBuilder.newTrigger().withIdentity(name, group)
                .withSchedule(CronScheduleBuilder.cronSchedule(expression)).build();
        scheduler.scheduleJob(job,trg);
    }
    //启动
    public void start() throws SchedulerException {
        if (!scheduler.isStarted())
            scheduler.start();
        log.info("启动成功。。。。");
    }


}
