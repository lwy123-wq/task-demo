package com.example.task2.quartz;


import com.example.task2.dao.QuartzDao;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;

@Configurable
@Slf4j
public class JobContext implements Job {
    @Autowired
    private QuartzDao quartzDao;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("当前时间{}",new Date());
        //TODO
        String str="当前时间"+new Date();
        quartzDao.insert(str);

    }
}
