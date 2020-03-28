package com.geek.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 和 Spring 连接相关的配置类。
 */
//@Configuration// 这是第一关。如果有 @Import，这个也可以不写。
@PropertySource("classpath:jdbcConfig.properties")
public class JDBCConfig {

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建一个 QueryRunner 对象。
     *
     * @param dataSource
     * @return
     */
    @Bean("queryRunner")// 把当前方法的返回值作为 bean 对象放进 Spring IoC 容器中。
    // 属性：name ——> 指定 bean 的 id。不写默认为当前方法的名称。
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        // 当我们使用注解配置方法时，如果方法有参数，Spring 会去容器中查找有没有可用的 bean。
        // 查找的方式的 @Autowired 的作用是一样的。

        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象。
     *
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql://192.168.223.128/geek_spring_dbutils");
//            dataSource.setUser("root");
//            dataSource.setPassword("root");

            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);

            return dataSource;
        } catch (PropertyVetoException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
