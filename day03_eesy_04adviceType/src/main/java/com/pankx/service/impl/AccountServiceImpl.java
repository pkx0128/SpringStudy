package com.pankx.service.impl;

import com.pankx.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("账户保存了。。。");
//        int i = 1/0;
    }

    /**
     * 模拟更新账户信息
     *
     * @param id
     */
    public void updateAccount(int id) {
        System.out.println("成功更新账户信息");
    }

    /**
     * 模拟删除账户信息
     *
     * @return
     */
    public int deleteAccount() {
        System.out.println("删除成功");
        return 0;
    }
}
