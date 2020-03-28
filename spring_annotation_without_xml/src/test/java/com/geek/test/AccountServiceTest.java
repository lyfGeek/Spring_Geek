package com.geek.test;

import com.geek.config.SpringConfiguration;
import com.geek.domain.Account;
import com.geek.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用 JUnit 单元测试。
 * Spring 整合 Junit。
 * + 导入 jar 包。（Maven）。
 * + 使用 Junit 提供的注解把原有的 main(); 方法替换了，替换成 Spring 提供的
 * ——> @RunWith
 * <p>
 * + 告知 Spring 的运行器，Spring 的 IoC 的创建是基于 xml 还是基于注解的。并且说明位置。
 * <p>
 * > @ContextConfiguration()
 * > + locations ——> 指定 xml 文件的位置，加上 classpath 关键字，表示在类路径下。
 * > + classes ——> 指定注解类所在位置。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private ApplicationContext applicationContext = null;
    private IAccountService accountService = null;

    @Before
    public void init() {
        // 获取容器。
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 业务层对象。
        accountService = applicationContext.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {
        // 执行方法。
        List<Account> accounts = accountService.FindAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findAccountById(1);
        System.out.println("account = " + account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("李");
        account.setMoney(1000F);

        // 执行方法。
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findAccountById(2);
        account.setName("testUpdate");
        account.setMoney(234F);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }

}
