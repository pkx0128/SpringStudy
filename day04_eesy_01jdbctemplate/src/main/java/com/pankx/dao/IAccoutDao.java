package com.pankx.dao;

import com.pankx.domain.Account;

public interface IAccoutDao {
    /**
     * 根据id查找账号
     * @param id
     * @return Account
     */
    Account findById(Integer id);

    /**
     * 根据名字查询徽号
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新账号信息
     * @param account
     */
    void updataAccount(Account account);
}
