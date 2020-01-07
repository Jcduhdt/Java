package com.jcduhdt.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-14
 * 和事务管理相关的工具类
 * 包含开启事务，提交事务，回滚事务，释放连接
 */
@Component("txmanager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.jcduhdt.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */

    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//归还连接池
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtVale = null;
        try{
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtVale = pjp.proceed(args);
            //4.提交事务
            this.commit();
            //返回结果
            return rtVale;
        } catch (Throwable e) {
            //5.回滚事务
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            this.release();
        }
    }
}
