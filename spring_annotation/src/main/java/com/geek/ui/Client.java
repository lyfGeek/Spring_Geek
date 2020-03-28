package com.geek.ui;

import com.geek.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层。
 */
public class Client {

    /**
     * 获取 SpringIoC 核心容器，并根据 id 获取对象。
     *
     * @param args
     */
    public static void main(String[] args) {

        // 创建核心容器对象。
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 根据 id 获取 Bean 对象。
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");

        System.out.println("accountService = " + accountService);

        accountService.saveAccount();

//        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
//
//        System.out.println("accountDao = " + accountDao);
    }
}
