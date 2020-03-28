package com.geek.service.impl;

import com.geek.dao.IAccountDao;
import com.geek.domain.Account;
import com.geek.service.IAccountService;

import java.util.List;

public class AccountServiceImpl_old implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账操作。
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("transfer...");

        // 根据名称查询转出账户。
        Account source = accountDao.findByName(sourceName);
        // 根据名称查询转入账户。
        Account target = accountDao.findByName(targetName);
        // 转出账户减钱。
        source.setMoney(source.getMoney() - money);
        // 转入账户加钱。
        target.setMoney(target.getMoney() + money);
        // 更新转出账户。
        accountDao.updateAccount(source);

        int a = 1 / 0;

        // 更新转入账户。
        accountDao.updateAccount(target);
    }

    /**
     * 查找全部。
     *
     * @return
     */
    @Override
    public List<Account> FindAllAccount() {
        return accountDao.FindAllAccount();
    }

    /**
     * 根据 id 查找一个。
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 保存。
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 修改。
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 删除。
     *
     * @param accountId
     */
    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
