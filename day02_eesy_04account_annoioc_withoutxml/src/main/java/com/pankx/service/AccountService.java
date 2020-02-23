package com.pankx.service;

import com.pankx.domain.Account;

import java.util.List;

/**
 * 账号的业务接口
 */
public interface AccountService {
    /**
     * 查询所有账号信息
     * @return
     */
    public List<Account> findAllAccount();

    /**
     * 根据ID查询一个用户信息
     * @return
     */
    public Account findAccountById(Integer id);

    /**
     * 保存用户信息
     */
    public void saveAccount(Account account);

    /**
     * 修改用户信息
     */
    public void updateAccount(Account account);

    /**
     * 根据用户id删除账号
     * @param id
     */
    public void deleteAccountById(Integer id);
}
