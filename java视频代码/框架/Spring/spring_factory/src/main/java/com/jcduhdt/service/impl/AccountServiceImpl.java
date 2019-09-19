package com.jcduhdt.service.impl;

import com.jcduhdt.dao.AccountDao;
import com.jcduhdt.dao.impl.AccountDaoImpl;
import com.jcduhdt.factory.BeanFactory;
import com.jcduhdt.service.AccountService;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();

    private  AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");


    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
