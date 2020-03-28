package com.geek.dao.impl;

import com.geek.dao.IAccountDao;

/**
 * 账户持久层实现类。
 */
public class AccountDaoImpl implements IAccountDao {

    public void save() {
        System.out.println("~ ~ ~ ~ ~ ~ ~");
        System.out.println("account saved...");
        System.out.println("~ ~ ~ ~ ~ ~ ~");
    }
}
