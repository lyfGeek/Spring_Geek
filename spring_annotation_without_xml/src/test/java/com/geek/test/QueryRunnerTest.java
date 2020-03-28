package com.geek.test;

import com.geek.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {

    @Test
    public void testQueryRunner() {

        // 获取容器。
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 获取 QueryRunner 对象。
        QueryRunner queryRunner = applicationContext.getBean("queryRunner", QueryRunner.class);
        QueryRunner queryRunner1 = applicationContext.getBean("queryRunner", QueryRunner.class);
        System.out.println(queryRunner == queryRunner1);

    }
}
