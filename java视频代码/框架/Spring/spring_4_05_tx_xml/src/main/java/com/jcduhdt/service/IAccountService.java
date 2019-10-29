package com.jcduhdt.service;

import com.jcduhdt.domain.Account;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-29
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
