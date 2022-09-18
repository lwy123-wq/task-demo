package com.example.task2.service;

import com.example.task2.dao.QuartzDao;
import com.example.task2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzService {

    @Autowired
    private QuartzDao quartzDao;
    public List<User> select(){
        return quartzDao.select();
    }
}
