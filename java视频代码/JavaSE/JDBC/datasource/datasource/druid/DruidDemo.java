package datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */

//Druid演示
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        //4获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        //5.获取链接
        Connection conn =ds.getConnection();
        System.out.println(conn);
    }
}
