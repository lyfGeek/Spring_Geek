package com.geek.service.impl;

import com.geek.dao.IAccountDao;
import com.geek.dao.impl.AccountDaoImpl;
import com.geek.service.IAccountService;

/**
 * 账户的业务层实现类。
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.save();
    }
}
