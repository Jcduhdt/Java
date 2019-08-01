package jdbc;

import java.sql.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-01
 */
//创建表
public class JdbcDemo4 {
    public static void main(String[] args) {
        Statement stmt = null;//因为try catch所以要提升作用于
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "select * from work_log";

            conn = DriverManager.getConnection("jdbc:mysql:///zx_log?useSSL=false&serverTimezone=UTC","root","zx041400414.");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //处理结果
            //游标初始位置是字段名所在的行数
            //让游标向下移动一行
            //循环判断游标是否是最后一行末尾
            //是返回false, 不是末尾，返回true
            while (rs.next()) {
                //获取数据
                int id = rs.getInt(1);
                String place = rs.getString("work_place");
                String felling = rs.getString("work_felling");
                String things = rs.getString("work_things");

                System.out.println(id + "---" + place + "---" + felling + "---" + things);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常
            //最后申请，先释放
            if (rs != null)
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
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
