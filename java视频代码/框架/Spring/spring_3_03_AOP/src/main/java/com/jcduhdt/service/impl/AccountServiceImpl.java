package com.jcduhdt.service.impl;

import com.jcduhdt.service.IAccountService;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-15
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
