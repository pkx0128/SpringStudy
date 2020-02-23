package com.pankx.dao;

import com.pankx.domain.Account;

public interface IAccountDao {
    /**
     * 根据id查找账号
     * @param id
     * @return Account
     */
    Account findAccountById(Integer id);

    /**
     * 根据名字查询徽号
     * @param name
     * @return
     */
    Account getAccountByName(String name);

    /**
     * 更新账号信息
     * @param account
     */
    void updateAccount(Account account);
}
