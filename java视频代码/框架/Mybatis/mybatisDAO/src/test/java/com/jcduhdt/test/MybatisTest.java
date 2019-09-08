package com.jcduhdt.test;

import com.jcduhdt.dao.UserDao;
import com.jcduhdt.dao.impl.UserDaoImpl;
import com.jcduhdt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-07
 * 测试mybatis的curd操作
 */
public class MybatisTest {
    private InputStream in;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂对象创建Dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        //提交事务

        in.close();
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){

        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("dao impl saveuser");
        user.setAddress("四川省成都市");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前:"+user);

        //5.执行查询所有方法
        userDao.saveUser(user);
        System.out.println("保存操作之后:"+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(50);
        user.setUsername("user dao impl updateuser");
        user.setAddress("四川省成都市");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行查询所有方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){

        //5.执行删除方法
        userDao.deleteUser(51);
    }
    /**
     * 测试根据id查询操作
     */
    @Test
    public void testFindOne(){

        //5.执行查询一个方法
        User user = userDao.findById(52);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){

        //5.执行模糊查询
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){

        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }


}
