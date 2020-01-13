package com.jcduhdt.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-09
 */
public class User implements Serializable {
    private String uname;
    private Integer age;
    private Date date;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
