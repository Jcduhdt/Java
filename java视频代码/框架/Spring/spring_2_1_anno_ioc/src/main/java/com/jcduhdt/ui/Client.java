package com.jcduhdt.ui;

import com.jcduhdt.dao.AccountDao;
import com.jcduhdt.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");//拿到object类型，自己强转
//        AccountService as2 = (AccountService) ac.getBean("accountService");//拿到object类型，自己强转
//        System.out.println(as);
//
//        AccountDao adao = ac.getBean("accountDao",AccountDao.class);
//        System.out.println(adao);
//        System.out.println(as==as2);
        as.saveAccount();
        ac.close();
    }
}
