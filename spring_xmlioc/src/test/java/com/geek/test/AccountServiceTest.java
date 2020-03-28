package com.geek.test;

import com.geek.domain.Account;
import com.geek.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用 JUnit 单元测试。
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 业务层对象。
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        // 执行方法。
        List<Account> accounts = accountService.FindAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

    }

    @Test
    public void testSave() {
        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 业务层对象。
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setName("testSave");
        account.setMoney(1000F);

        // 执行方法。
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 业务层对象。
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        Account account = accountService.findAccountById(2);
        account.setName("testUpdate");
        account.setMoney(234F);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 业务层对象。
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        accountService.deleteAccount(4);
    }

}
