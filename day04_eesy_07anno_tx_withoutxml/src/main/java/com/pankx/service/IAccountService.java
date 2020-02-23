package com.pankx.service;

import com.pankx.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查看账户
     * @param accountid
     * @return
     */
    Account findAccountById(Integer accountid);

    /**
     * 转账
     * @param sourceName 转出账户名
     * @param tagName 转入账户名
     * @param money 钱
     */
    void transfer(String sourceName,String tagName,Float money);
}
