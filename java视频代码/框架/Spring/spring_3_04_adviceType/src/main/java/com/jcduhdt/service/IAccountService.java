package com.jcduhdt.service;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-15
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     */
    void updateAccount(int i);

    /**
     * 删除账户
     */
    int deleteAccount();
}
