package com.sam.domain;

import com.alibaba.fastjson.JSON;

/**
 * Created by sam on 16/5/29.
 */
public class User {

    private String userId;

    private String userName;

    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
