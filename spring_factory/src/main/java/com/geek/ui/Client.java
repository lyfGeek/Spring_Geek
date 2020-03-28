package com.geek.ui;

import com.geek.factory.BeanFactory;
import com.geek.service.IAccountService;

/**
 * 模拟一个表现层，用于调用业务层。
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();

        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println("accountService = " + accountService);
            accountService.saveAccount();
        }

        // 多例 & 单例。
        // accountService = com.geek.service.impl.AccountServiceImpl@1540e19d
        //accountService = com.geek.service.impl.AccountServiceImpl@677327b6
        //accountService = com.geek.service.impl.AccountServiceImpl@14ae5a5
        //accountService = com.geek.service.impl.AccountServiceImpl@7f31245a
        //accountService = com.geek.service.impl.AccountServiceImpl@6d6f6e28

        // accountService = com.geek.service.impl.AccountServiceImpl@1540e19d
        //accountService = com.geek.service.impl.AccountServiceImpl@1540e19d
        //accountService = com.geek.service.impl.AccountServiceImpl@1540e19d
        //accountService = com.geek.service.impl.AccountServiceImpl@1540e19d
        //accountService = com.geek.service.impl.AccountServiceImpl@1540e19d


//        System.out.println("accountService = " + accountService);

//        accountService.saveAccount();
    }
}
