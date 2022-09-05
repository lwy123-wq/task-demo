package com.example.task2.dao;

import com.example.task2.entity.Text;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TestDao{
    @Autowired
    private TestRepository repository;
    public void saveDate(int id,String name){
        repository.addDate(id,name);
        log.info("添加成功..........");

    }


}

