package com.geek.service.impl;

import com.geek.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类。
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    /**
     * 模拟保存账户。
     */
    @Override
    public void saveAccount() {
        System.out.println("执行了保存账户操作。");
    }

    /**
     * 模拟更新账户。
     *
     * @param i
     */
    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新账户操作。");
    }

    /**
     * 删除账户。
     *
     * @return
     */
    @Override
    public int deleteAccount() {
        System.out.println("执行了删除账户操作。");
        return 0;
    }
}
