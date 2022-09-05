package com.example.task2.dao;

import com.example.task2.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TestRepository extends JpaRepository<Text,Integer> {
    /***
     * 添加数据
     */

    @Transactional
    @Modifying
    @Query(value = "insert into test(id,test) value(?,?)",nativeQuery = true)
    public int addDate(@Param("id") Integer id,@Param("test") String test);



}
