package datasource.druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */

/*
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /*
         * 完成添加操作 给test表添加操作
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取链接
            conn = JDBCUtils.getConnection();
            //2.定义sql语句
            String sql = "insert into test value(null,?,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"xiannv");
            pstmt.setString(2,"468");
            pstmt.setDouble(3,13436);
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }
}
