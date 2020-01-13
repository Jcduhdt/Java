package com.jcduhdt.dao;

import com.jcduhdt.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2020-01-12
 * 账户dao借口
 */
@Repository
public interface AccountDao {

    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}
