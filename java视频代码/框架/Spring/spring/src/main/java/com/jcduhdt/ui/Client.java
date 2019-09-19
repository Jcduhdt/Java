package com.jcduhdt.ui;

import com.jcduhdt.dao.AccountDao;
import com.jcduhdt.service.AccountService;
import com.jcduhdt.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
     * 获取spring容器的Ioc核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容
     *
     * 核心容器的两个接口引发的问题：
     *  ApplicationContext: 单例对象适用  更多时候采用此接口创建对象
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     *  BeanFactory：  多例对象适用
     *      他在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正创建对象
     * @param args
     */
    public static void main(String[] args) {
       /* //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("F:\\bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");//拿到object类型，自己强转
        AccountDao adao = ac.getBean("accountDao", AccountDao.class);//传给他字节码，让他用字节码自家强转

        System.out.println(as);
        System.out.println(adao);*/

        //--------------BeanFactory------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = (AccountService) factory.getBean("accountService");
        System.out.println(as);
    }
}
