package com.geek.aoptest;

import com.geek.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 aop 的配置。
 */
public class AOPTest {

    public static void main(String[] args) {
        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");
        // 获取对象。
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        // 执行方法。
        accountService.saveAccount();
    }
}
