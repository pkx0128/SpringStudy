package com.pankx.dao;

import com.pankx.domain.Account;

import java.util.List;

/**
 * acount持久层接口
 */
public interface IAccountDAO {
    /**
     * 查询account中的所有数据
     * @return List<Account>
     */
    public List<Account> findAll();

}
