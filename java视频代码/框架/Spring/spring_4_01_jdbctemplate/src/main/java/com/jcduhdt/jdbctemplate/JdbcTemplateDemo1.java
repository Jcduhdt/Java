package com.jcduhdt.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-17
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");

        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.给jt设置数据源
        jt.setDataSource(ds);
        //3.执行操作
        jt.execute("insert into account(name,money)value('ddd',2000)");
    }
}
