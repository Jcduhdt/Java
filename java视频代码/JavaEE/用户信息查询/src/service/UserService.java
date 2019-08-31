package service;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-29
 */

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
    public User login(User user);

    //保存user
    void addUser(User user);

    //根据id删除User
    void delUser(String id);

    //根据id查询
    User findUserById(String id);

    void updateUser(User user);

    //批量删除用户
    void delSelectedUser(String[] ids);

    //分页条件查询
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}

