package com.geek.dao.impl;

import com.geek.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类。
 */
@Repository("accountDao02")
public class AccountDaoImpl02 implements IAccountDao {

    public void save() {
        System.out.println("~ ~ ~ ~ ~ ~ ~");
        System.out.println("account saved...222");
        System.out.println("~ ~ ~ ~ ~ ~ ~");
    }
}
