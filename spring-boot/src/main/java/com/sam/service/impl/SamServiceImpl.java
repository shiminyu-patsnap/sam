package com.sam.service.impl;

import com.sam.dao.UserDao;
import com.sam.service.SamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamServiceImpl implements SamService {

    @Autowired
    private UserDao userDao;

    @Override
    public String queryUserName(String email) {
        return userDao.queryUserName(email);
    }
}
