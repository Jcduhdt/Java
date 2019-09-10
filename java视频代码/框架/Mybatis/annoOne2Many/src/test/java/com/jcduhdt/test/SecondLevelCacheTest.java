package com.jcduhdt.test;

import com.jcduhdt.dao.UserDao;
import com.jcduhdt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-10
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destorday() throws Exception {
        in.close();
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(52);
        System.out.println(user);
        session.close();//释放一级缓存

        SqlSession session1 = factory.openSession();//再次打开session
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user1 = userDao1.findById(52);
        System.out.println(user1);

        session1.close();
    }
}
