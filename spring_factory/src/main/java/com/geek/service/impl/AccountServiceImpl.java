package com.geek.service.impl;

import com.geek.dao.IAccountDao;
import com.geek.factory.BeanFactory;
import com.geek.service.IAccountService;

/**
 * 账户的业务层实现类。
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    // 自己 new 对象，有完全的控制权。

    int i = 1;// 如果是单例模式，print(i) 会改变。
    // 放弃了自己创建对象的权力，把权力交给工厂。
    // 不再自己控制——> 控制反转。
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    // 线程共享问题。
    // 如果在方法体中，则不存在此问题。

    public void saveAccount() {
        accountDao.save();

//        int i = 1;
        System.out.println("i = " + i);

        i++;
    }
}
