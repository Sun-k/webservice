package com.example.webservice.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sunk
 * @create 2018-4-19-16:40
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -5939599230753662529L;

    private String userId;
    private String userName;
    private String age;
    private Date updateTIme;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }
}
