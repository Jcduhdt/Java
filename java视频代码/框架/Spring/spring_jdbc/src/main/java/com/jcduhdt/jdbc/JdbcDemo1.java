package com.jcduhdt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-11
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：
 *              类之前的依赖
 *              方法间的依赖
*       解耦：
 *          降低程序间的依赖关系
 *      实际开发中：
 *          应做到：编译器不依赖，运行时才依赖
 *      解耦思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二步：通过读取配置文件获取要创建的对象全限定类名
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动 两种注册方式
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());//这东西，没有jar包的话，就会编译错误
        Class.forName("com.mysql.cj.jdbc.Driver");//没有jar包，运行时错误
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///spring?useSSL=false&serverTimezone=UTC", "root", "root");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
