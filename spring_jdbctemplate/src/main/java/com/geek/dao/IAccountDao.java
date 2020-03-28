package com.geek.dao;

import com.geek.domain.Account;

/**
 * 账户的持久层接口。
 */
public interface IAccountDao {

    /**
     * 根据 id 查询账户。
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据 name 查询账户。
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 修改账户。
     *
     * @param account
     */
    void updateAccount(Account account);
}
