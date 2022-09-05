package com.example.task2;

import com.example.task2.dao.QuartzDao;
import com.example.task2.dao.TestRepository;
import com.example.task2.quartz.JobContext;
import com.example.task2.quartz.QuartzManager;
import com.example.task2.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import javax.xml.ws.Service;

@SpringBootTest
@Slf4j
@EnableCaching
class Task2ApplicationTests {
    @Autowired
    private QuartzDao quartzDao;
    @Autowired
    private TestService testService;
    @Autowired
    private TestRepository repository;

    @Test
    void contextLoads() throws SchedulerException {
//        QuartzManager manager=QuartzManager.getInstance();
//        manager.addJob("jobName","jobGroup", JobContext.class,"0 0 0/15-16 ? * TUE,THU",null);
//        manager.start();
        //quartzDao.insert("aa");
        //testService.insert();
        //System.out.println(quartzDao.select());
        //log.info("this is ok");
        System.out.println(repository.addDate(3, "aa"));
    }

}
