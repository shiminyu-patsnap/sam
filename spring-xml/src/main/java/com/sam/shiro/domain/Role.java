package com.sam.shiro.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sam on 16/6/16.
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -4987248128309954399L;

    private Integer id;

    private String name;

    private Set<Permission> permissionSet = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
