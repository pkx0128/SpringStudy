package com.pankx.service;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户信息
     * @param id
     */
    void updateAccount(int id);

    /**
     * 模拟删除账户信息
     * @return
     */
    int deleteAccount();


}
