package com.example.task2.controller;

import com.example.task2.dao.QuartzDao;
import com.example.task2.entity.User;
import com.example.task2.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class QuartzController {
    @Autowired
    private QuartzService quartzService;
    @RequestMapping(value = "/aaa")
    @ResponseBody
    public List quart(){
        List<String> list1=new ArrayList<>();
        List<User> list=quartzService.select();
        for (User user:list){
            list1.add(user.getUsername());
        }
        log.info("添加成功...........");

        return list1;
    }
    /*@RequestMapping(value = "/aa")
    @ResponseBody
    public String test(){
        return "aaaaaaaaaa";
    }*/
}
