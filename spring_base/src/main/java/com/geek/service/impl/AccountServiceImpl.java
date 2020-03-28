package com.geek.service.impl;

import com.geek.dao.IAccountDao;
import com.geek.service.IAccountService;

/**
 * 账户的业务层实现类。
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = null;
    /*
    Exception in thread "main" java.lang.NullPointerException
	at com.geek.service.impl.AccountServiceImpl.saveAccount(AccountServiceImpl.java:18)
	at com.geek.ui.Client.main(Client.java:33)
	*/

    public AccountServiceImpl() {
        System.out.println("对象创建了。");
    }

    public void saveAccount() {
        accountDao.save();
    }
}
