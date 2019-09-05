package com.jcduhdt.dao.impl;

import com.jcduhdt.dao.ItemsDao;
import com.jcduhdt.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-05
 */
public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list = null;

        list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///userinf?useSSL=false&serverTimezone=UTC","root","root");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from user");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库结果集转成java的list集合
            while (rs.next()){
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
