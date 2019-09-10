package com.jcduhdt.test;

import com.jcduhdt.dao.AccountDao;
import com.jcduhdt.dao.UserDao;
import com.jcduhdt.domain.Account;
import com.jcduhdt.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-10
 */
public class AnnotationTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void destorday() throws Exception {
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("--------每个账户的信息--------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
