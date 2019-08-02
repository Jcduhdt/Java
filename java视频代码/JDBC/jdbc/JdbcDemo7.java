package jdbc;

import util.JdbcUtilsDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-02
 */

/*
 * 需求：
 * 1.通过键盘录用户名和密码
 * 2.判断用户是否登陆成功
 */
public class JdbcDemo7 {

    public static void main(String[] args) {
        //键盘接收用户名和密码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = in.nextLine();
        System.out.println("请输入密码：");
        String password = in.nextLine();
        //调用方法
        boolean flag = new JdbcDemo7().login(username,password);
        //判断结果，输出不同语句
        if (flag){
            System.out.println("登陆成功！");
        }else{
            System.out.println("用户名或密码错误！");
        }
    }




    /**
     * 登陆方法
     */
    public boolean login(String username,String password){
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //链接数据库判断是否登陆成功
        try {
            conn = JdbcUtilsDemo.getConnection();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            /*if (rs.next()){
                return true;
            }else{
                return false;
            }*/
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtilsDemo.close(rs,stmt,conn);
        }


        return false;
    }
}
