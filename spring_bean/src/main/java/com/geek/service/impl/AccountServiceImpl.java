package com.geek.service.impl;

import com.geek.service.IAccountService;

/**
 * 账户的业务层实现类。
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("默认构造方法。（对象创建了）。");
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount()方法 执行了。");
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
