package com.jcduhdt.service.impl;

import com.jcduhdt.service.AccountService;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("Service中的saveAccount方法执行了");
    }
    public void init(){
        System.out.println("对象初始化了。");
    }
    public void destroy(){
        System.out.println("对象销毁了");
    }
}
