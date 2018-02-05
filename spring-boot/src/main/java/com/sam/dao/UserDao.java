package com.sam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 16/6/27.
 */
@Mapper
public interface UserDao {

    @Select("select name from user where email= #{email}")
    String queryUserName(@Param("email") String email);
}