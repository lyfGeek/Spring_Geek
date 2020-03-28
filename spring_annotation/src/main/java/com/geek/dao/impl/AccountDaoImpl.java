package com.geek.dao.impl;

import com.geek.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类。
 */
@Repository("accountDao01")
public class AccountDaoImpl implements IAccountDao {

    public void save() {
        System.out.println("~ ~ ~ ~ ~ ~ ~");
        System.out.println("account saved...111");
        System.out.println("~ ~ ~ ~ ~ ~ ~");
    }
}
