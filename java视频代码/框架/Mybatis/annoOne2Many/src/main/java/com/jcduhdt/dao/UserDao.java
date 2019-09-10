package com.jcduhdt.dao;

import com.jcduhdt.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-10
 * 在mybatis中，CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)//开启二级缓存的使用
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")//value 只有一个的时候可以省略不写
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id", property="userId"),
            @Result(column = "username", property="userName"),
            @Result(column = "address", property="userAddress"),
            @Result(column = "sex", property="userSex"),
            @Result(column = "birthday", property="userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(
                    select = "com.jcduhdt.dao.AccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{name}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

}
