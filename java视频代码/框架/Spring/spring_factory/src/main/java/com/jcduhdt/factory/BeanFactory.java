package com.jcduhdt.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 一个创建Bean对象的工厂
 *
 * Bean:在计算机英语中，有可重用组件的含义
 * JavaBean:用java语言编写的可重用组件
 *      javabean >> 实体类
 *
 *    它就是创建我们service和dao对象的
 *    第一个：需要一个配置文件来配置我们的service和dao
 *          配置内容：唯一标识=全限定类名（key=value）
 *    第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *    配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个map用于存放我们要创建的对象。称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象  .getClassLoader()啊！！！
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            int i =1;
            while(keys.hasMoreElements()){
                System.out.println(i++);
                //取出每个key
                String key = keys.nextElement().toString();
                System.out.println(key);
                //根据key获取value
                String beanPath = props.getProperty(key);
                System.out.println(beanPath);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }


    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        System.out.println(beanName+"123");
        return beans.get(beanName);
    }




    /**
     * 根据Bean的名称获取Bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
