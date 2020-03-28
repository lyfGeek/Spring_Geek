package com.geek.ui;

import com.geek.dao.IAccountDao;
import com.geek.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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

        // 获取核心容器对象。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 根据 id 获取 Bean 对象。
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");// 强转。
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);// 用字节码强转。

        System.out.println("accountService = " + accountService);
        System.out.println("accountDao = " + accountDao);

        accountService.saveAccount();

        // 加载类路径下的配置文件。
//        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        // 加载任意位置的配置文件。（要求有访问权限）。
//        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext();
        // 用于读取注解创建容器的。
//        ApplicationContext applicationContext3 = new AnnotationConfigApplicationContext();

        /**
         * 核心容器的两个接口。
         *
         * ApplicationContext。  ——> 单例模式适用。
         *      ta 在构建核心容器时，创建对象采取的策略是立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
         * BeanFactory。         ——> 多例模式适用。
         *      ta 在构建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说，什么时候根据 id 获取对象了，什么时候才创建对象。
         *
         * （可用断点演示。）
         */

        // ~~~~~~~ BeanFactory。
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountDao accountDao1 = (IAccountDao) factory.getBean("accountDao");
    }
}
