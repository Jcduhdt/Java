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

public class JdbcDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;//因为try catch所以要提升作用于
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //添加记录 insert
            String sql = "insert into work_log(work_place,work_felling,work_things) values('成都','一般','八点半给我')";
            //修改记录
            //String sql = "update work_log set work_felling = '要学习' where work_id = 10";
            //删除记录
//            String sql = "delete from work_log where work_id = 10";


            conn = DriverManager.getConnection("jdbc:mysql:///zx_log?useSSL=false&serverTimezone=UTC","root","zx041400414.");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
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
