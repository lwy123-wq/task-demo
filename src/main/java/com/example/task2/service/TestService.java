package com.example.task2.service;

import com.example.task2.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;
    public void insert(){
        for(int i=0;i<10;i++){
            testDao.saveDate(i,"aa");
        }
    }

}
