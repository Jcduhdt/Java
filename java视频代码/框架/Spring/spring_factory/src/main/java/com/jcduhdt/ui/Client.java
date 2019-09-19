package com.jcduhdt.ui;

import com.jcduhdt.factory.BeanFactory;
import com.jcduhdt.service.AccountService;
import com.jcduhdt.service.impl.AccountServiceImpl;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        AccountService as = new AccountServiceImpl();
        for (int i=0;i<5;i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
