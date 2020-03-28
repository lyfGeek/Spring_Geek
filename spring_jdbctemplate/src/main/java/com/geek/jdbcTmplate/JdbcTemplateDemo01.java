package com.geek.jdbcTmplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplateDemo01 IoC。
 */
public class JdbcTemplateDemo01 {

    public static void main(String[] args) {

        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 获取对象。
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        // 执行操作。
        jdbcTemplate.execute("insert into account (name, money) values ('ddd', '1000')");
    }
}
