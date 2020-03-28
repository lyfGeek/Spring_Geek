package com.geek.ui;

import com.geek.service.IAccountService;
import com.geek.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层。
 */
public class Client {

    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl();

        accountService.saveAccount();
    }
}
