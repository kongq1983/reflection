package com.kq.java.type.entity;

import java.util.List;
import java.util.Map;

public class Company {

    private List<User> userList;
    private List<String> stringList;

    private Map<String,User> userMap;
    private Map<String,List<User>> userListMap;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "userList=" + userList +
                ", stringList=" + stringList +
                '}';
    }
}
