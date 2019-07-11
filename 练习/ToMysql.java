import java.sql.*;
import java.util.Scanner;

/**
 * @version v12.0.1 2019-7-10
 * @author Zhang xiong
 */

/*
 * java连接MySQL需要添加jdbc驱动
 * mysql_connector.jar包我放在jdk/lib下的
 * 导入jar包
 * 步骤：
 * 1.打开要添加jar包的project
 * 2.flie-project Structure
 * 3.Moudules dependencies
 * 4.Moudule source 点击右边+号的第一个jar..把它添加进去
 * 5.选中，确定
 */
public class ToMysql
{
    public static void main(String[] args)
    {
        entry();
    }

    public static void entry()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String user = in.next();//我特么还以为什么地方又有毛病了，结果运行之后就一直在等待我输入
        //我又没看到有提示，下方一片空白，找了好久。。哭
        System.out.print("请输入密码: ");
        String password = in.next();
        try
        {
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载JDBC驱动程序
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zx_log?serverTimezone=UTC",
                    user,password);//连接字符串要加?serverTimezone=UTC，不然有错误，似乎是中文乱码
            Statement stmt = con.createStatement();

            System.out.println("连接成功");
            try {
                System.out.print("输入查询语句: ");
                // 获取sql语句  "select * from work_log";
                // String sql = in.next();// next不能得到带空格的字符串 得到的结果是 select*
                in.nextLine();//添加一个nextLine()是因为这个函数得到了\n也会得到结果，需要多一行来吸收\n
                //但是我不懂为什么会多出来一个\n
                String sql = in.nextLine();//直接输入select * from work_log 就行 分号加不加都可以  亲测
                sqlOpration(con,sql);
            }
            catch(Exception e)
            {

            }
        }
        catch(Exception e)
        {
            System.out.println("用户名或密码错误！");
            System.out.println("MYSQL ERROR: " + e.getMessage());
            System.out.println();
            entry();
        }
        in.close();
    }

    public static void sqlOpration(Connection con,String sql) throws SQLException {
        /*要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3种类型：   
          1）执行静态SQL语句。通常通过Statement实例实现。   
          2）执行动态SQL语句。通常通过PreparedStatement实例实现。   
          3）执行数据库存储过程。通常通过CallableStatement实例实现。
        */
        Statement stmt = con.createStatement();
        /*在询数据表时，需要用到ResultSet接口，它类似于一个数据表，通过该接口的实例
         * 可以获得检索结果集，以及对应数据表的接口信息。*/
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
        while (rs.next())
        {
            /*
             * 问题：
             * 1.怎么才能动态显示我所获取的表的内容，而不知每次去修改打印的类型及字段
             * 2.怎么才能实现打印的字段的对齐
             */
            System.out.print("id: " + rs.getInt("work_id"));
            System.out.print(", place: " + rs.getString("work_place"));
            System.out.print(", felling: " + rs.getString("work_felling"));
            System.out.println(", date: " + rs.getDate("work_time"));
        }

    }
}
