package com.geek.jdbcTmplate;

import com.geek.dao.IAccountDao;
import com.geek.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JdbcTemplateDemo01 IoC。
 */
public class JdbcTemplateDemo04 {

    public static void main(String[] args) {

        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 获取对象。
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);

        // 执行操作。
        Account account = accountDao.findAccountById(1);

        System.out.println("account = " + account);
    }
}
