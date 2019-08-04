package jdbc;

import util.JdbcUtilsDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */
public class JdbcDemo8 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try{
            conn = JdbcUtilsDemo.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql1 = "update account set balance = balabce - ? where id = ?";
            String sql2 = "update account set balance = balabce + ? where id = ?";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();

            //手动制造异常
            int i = 3/0;
            pstmt2.executeUpdate();

            //提交事务
            conn.commit();
        }catch(Exception e){
            //事务回滚
            try {
                if (conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            JdbcUtilsDemo.close(null,pstmt1,conn);
            JdbcUtilsDemo.close(null,pstmt1,null);
        }
    }
}
