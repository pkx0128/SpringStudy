package com.pankx.Dao.impl;

import com.pankx.Dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {

    public void save() {
        System.out.println("AccountDaoImpl的save方法执行了11111111111111");
    }
}
