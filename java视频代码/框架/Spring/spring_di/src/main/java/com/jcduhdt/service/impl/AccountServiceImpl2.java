package com.jcduhdt.service.impl;

import com.jcduhdt.service.AccountService;

import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("Service中的saveAccount方法执行了"+name+age+birthday);
    }
}
