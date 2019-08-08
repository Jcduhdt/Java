package jdbc;

import domain.Vendors;
import util.JdbcUtilsDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-01
 */

/**
 * 正确url = jdbc:mysql:///student?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
 * 不添加?后面的内容会报错，都是mysql8版本的需要。。但是allowPublicKeyRetrieval=true
 * 这东西似乎添加一次就行，因为想把错误再显示出来把这段删了但是还是可以运行
 */


//定义一个方法,查询库student的表vendors的数据将其封装为对象，然后装载集合，返回打印

public class JdbcDemo6 {


    public static void main(String[] args) {
        List<Vendors> list = new JdbcDemo6().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 演示JDBCUtils
     * 查询所有Vendors对象
     * @return
     */
    public List<Vendors> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Vendors> list = null;
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///student?useSSL=false&serverTimezone=UTC","root","zx041400414.");
            conn = JdbcUtilsDemo.getConnection();
            String sql = "select * from vendors";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //遍历结果，封装对象，装载集合
            Vendors vendors = null;
            list = new ArrayList<Vendors>();
            while (rs.next()){
                int vend_id = rs.getInt("vend_id");
                String vend_name = rs.getString("vend_name");
                String vend_address = rs.getString("vend_address");
                String vend_city = rs.getString("vend_city");
                String vend_state = rs.getString("vend_state");
                String vend_zip = rs.getString("vend_zip");
                String vend_country = rs.getString("vend_country");
                //创建Vendors对象
                vendors = new Vendors();
                vendors.setVend_id(vend_id);
                vendors.setVend_name(vend_name);
                vendors.setVend_address(vend_address);
                vendors.setVend_city(vend_city);
                vendors.setVend_state(vend_state);
                vendors.setVend_zip(vend_zip);
                vendors.setVend_country(vend_country);
                //装载集合
                list.add(vendors);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtilsDemo.close(rs,stmt,conn);
        }
        return list;
    }
}
