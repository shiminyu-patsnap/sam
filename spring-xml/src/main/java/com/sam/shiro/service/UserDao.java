package com.sam.shiro.service;

import com.sam.shiro.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by sam on 16/6/16.
 */
@Service
public interface UserDao {

    User findUserByUsername(String usermame);
}
