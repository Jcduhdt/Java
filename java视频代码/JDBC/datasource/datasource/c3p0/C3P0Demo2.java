package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */

/*
 * c3p0的演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象  什么都不传使用默认配置
            DataSource ds = new ComboPooledDataSource();
            //获取连接对象
            for (int i = 1; i <= 11; i++) {
                Connection conn = ds.getConnection();
                System.out.println(i + ":" + conn);

                if (i == 5) {
                    conn.close();//归还链接到连接池中
                }
            }
//         testNamedConfig();

    }

    public static void testNamedConfig() throws SQLException {
        //使用指定名称配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //获取连接对象
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);

            if (i==5){
                conn.close();//归还链接到连接池中
            }
        }
    }
}
