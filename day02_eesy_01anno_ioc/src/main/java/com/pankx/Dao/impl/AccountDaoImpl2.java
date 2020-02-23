package com.pankx.Dao.impl;

import com.pankx.Dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {

    public void save() {
        System.out.println("AccountDaoImpl的save方法执行了22222222222222");
    }
}
