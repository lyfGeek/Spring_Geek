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
        IAccountService accountService1 = (IAccountService) applicationContext.getBean("accountService");
//        IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService");

        System.out.println(accountService1);

        // 手动关闭容器。
        applicationContext.close();
    }
}
