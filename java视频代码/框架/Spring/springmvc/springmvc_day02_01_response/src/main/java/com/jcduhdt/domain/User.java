package com.jcduhdt.domain;

import java.io.Serializable;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-09
 */
public class User implements Serializable {
    private String username;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
