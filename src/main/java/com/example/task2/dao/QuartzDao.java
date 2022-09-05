package com.example.task2.dao;


import com.example.task2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class QuartzDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insert(String str){
        String sql="insert into user(username)values (?)";
        return jdbcTemplate.update(sql,str);
    }
    public List<User> select(){
        String sql="select username from user";
        User user=new User();
        List<User> list=jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                user.setUsername(rs.getString("username"));
                return user;
            }
        });
        return list;
    }

}
