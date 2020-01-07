package com.jcduhdt.dao.impl;

import com.jcduhdt.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 账户的持久层实现类
 */
@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("保存账户成功22222");
    }
}
