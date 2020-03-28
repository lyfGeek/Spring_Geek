package com.geek.jdbcTmplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplateDemo01 最基本用法。
 */
public class JdbcTemplateDemo00 {

    public static void main(String[] args) {

        // 准备数据源。（Spring 内置数据源）。
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://192.168.223.128/geek_spring_dbutils");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");

        // 创建 JdbcTemplate 对象。
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 给 jdbcTemplate 设置数据源。
        jdbcTemplate.setDataSource(driverManagerDataSource);

        // 执行操作。
        jdbcTemplate.execute("insert into account (name, money) values ('ccc', '1000')");
    }
}
