package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-31
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.jcduhdt")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement//开启spring注解
public class SpringConfiguration {
}
