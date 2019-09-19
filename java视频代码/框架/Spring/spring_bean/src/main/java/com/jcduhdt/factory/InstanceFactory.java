package com.jcduhdt.factory;

import com.jcduhdt.service.AccountService;
import com.jcduhdt.service.impl.AccountServiceImpl;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-19
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
