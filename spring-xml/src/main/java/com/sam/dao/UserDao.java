package com.sam.dao;

import com.sam.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 16/5/29.
 */
@Service
public interface UserDao {

    @Select("select customer_name from customer where email= #{email}")
    String queryUserNameByEmail(@Param("email") String email);

    User queryUserInfoByEmail(@Param("email") String email);
}
