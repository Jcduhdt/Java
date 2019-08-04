package jdbctemplate;

import domain.TestBiu;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */
public class JdbcTemplateDemo2 {

    //1.获取JdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //Junit单元测试，可以让方法独立执行

    /**
     * 1.修改2号数据的money为30000
     */
    @Test
    public void test1(){
        //1.获取JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update test set money = 30000 where id = 2";
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into test value(null,?,?,?)";
        int count = template.update(sql, "超森系", "41634", 45000);
        System.out.println(count);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from test where id = ?";
        int count = template.update(sql, 5);
        System.out.println(count);
    }

    /**
     * 4.查询id为1的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        String sql = "select * from test where id = ?";
        Map<String,Object> map = template.queryForMap(sql,1);
        System.out.println(map);//{id=1, name=zhangsan, password=123, money=50000.0}
    }

    /**
     * 6.查询所有记录，将其封装为Test对象的List集合
     * 注意：将每一条记录封装成map集合，再将map集合装载到list集合中就可以了
     */
    @Test
    public void test5(){
        String sql = "select * from test";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6.查询所有记录，将其封装为TestBiu对象的List集合
     * 自己写的
     */
    @Test
    public void test6(){
        String sql = "select * from test";
        List<TestBiu> list = template.query(sql, new RowMapper<TestBiu>() {

            @Override
            public TestBiu mapRow(ResultSet rs, int i) throws SQLException {
                TestBiu testbiu = new TestBiu();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                Double money = rs.getDouble("money");
                testbiu.setId(id);
                testbiu.setName(name);
                testbiu.setPassword(password);
                testbiu.setMoney(money);
                return testbiu;
            }
        });

        for (TestBiu testBiu : list) {
            System.out.println(testBiu);
        }
    }

    /**
     * 6.2 查询所有记录，将其封装为TestBiu对象的List集合
     */
    @Test
    public void test6_2(){
        String sql = "select * from test";
        List<TestBiu> list = template.query(sql,new BeanPropertyRowMapper<TestBiu>(TestBiu.class));
        for (TestBiu testBiu : list) {
            System.out.println(testBiu);
        }
    }


    /**
     * 7.查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from test";
        Long total = template.queryForObject(sql,Long.class);//第二个是返回值类型
        System.out.println(total);
    }
}
