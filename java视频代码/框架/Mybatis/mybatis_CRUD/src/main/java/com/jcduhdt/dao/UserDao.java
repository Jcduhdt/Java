package com.jcduhdt.dao;

import com.jcduhdt.domain.QueryVo;
import com.jcduhdt.domain.User;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-07
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
