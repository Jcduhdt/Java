package com.jcduhdt.service;

import com.jcduhdt.domain.Account;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-12
 */
public interface AccountService {
    //查询所有账户
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
