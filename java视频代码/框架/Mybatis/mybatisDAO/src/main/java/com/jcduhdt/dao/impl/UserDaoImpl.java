package com.jcduhdt.dao.impl;

import com.jcduhdt.dao.UserDao;
import com.jcduhdt.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-07
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }


    @Override
    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        List<User> users = sqlSession.selectList("com.jcduhdt.dao.UserDao.findAll");//参数就是能获取的配置信息的key
        //3.释放资源
        sqlSession.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        sqlSession.insert("com.jcduhdt.dao.UserDao.saveUser",user);//参数就是能获取的配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        sqlSession.update("com.jcduhdt.dao.UserDao.updateUser",user);//参数就是能获取的配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        sqlSession.delete("com.jcduhdt.dao.UserDao.deleteUser",id);//参数就是能获取的配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    @Override
    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        User user = sqlSession.selectOne("com.jcduhdt.dao.UserDao.findById",userId);//参数就是能获取的配置信息的key
        //3.释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        List<User> users = sqlSession.selectList("com.jcduhdt.dao.UserDao.findByName",username);
        //3.释放资源
        sqlSession.close();
        return users;
    }

    @Override
    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用SqlSession中的方法,实现查询列表
        Integer count = sqlSession.selectOne("com.jcduhdt.dao.UserDao.findTotal");
        //3.释放资源
        sqlSession.close();
        return count;
    }
}
