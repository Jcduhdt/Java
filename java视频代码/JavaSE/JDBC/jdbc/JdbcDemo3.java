package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-01
 */
//创建表
public class JdbcDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;//因为try catch所以要提升作用于
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "create table jdbchaha (id int,name varchar(20))";


            conn = DriverManager.getConnection("jdbc:mysql:///zx_log?useSSL=false&serverTimezone=UTC","root","zx041400414.");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常
            if (stmt != null)
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            if (conn != null)
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
        }
    }
}
