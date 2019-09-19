package com.jcduhdt.ui;

import com.jcduhdt.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");

        as.saveAccount();

        //手动关闭容器
        ac.close();
    }
}
