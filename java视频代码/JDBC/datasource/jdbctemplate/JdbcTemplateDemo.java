package jdbctemplate;

import utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */

/*
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update test set money = 24000 where id = ?";
        int count = template.update(sql,3);
        System.out.println(count);
    }
}
