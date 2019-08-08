package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-01
 */

/*
 * JDBC快速入门
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //1.导入驱动Jar包
        //file->project structure->modules->dependense->右边的+第一个
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        //因为连接的数据库时mysql8版本，所以需要在url上添加?useSSL=false&serverTimezone=UTC 否则会报错
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zx_log?useSSL=false&serverTimezone=UTC","root","zx041400414.");
        //定义sql语句
        //对于字段中为string的内容用''包括
        String sql = "update work_log set work_place = '成都' where work_id = 3";
        //获取执行sql的对象
        Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);
        //处理结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();

    }
}
