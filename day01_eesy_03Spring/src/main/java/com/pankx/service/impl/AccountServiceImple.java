package com.pankx.service.impl;

import com.pankx.Dao.AccountDao;
import com.pankx.Dao.impl.AccountDaoImpl;
import com.pankx.service.AccountService;

public class AccountServiceImple implements AccountService {

    //    AccountDao accountDao = new AccountDaoImpl();
    public AccountDao accountDao;

    public AccountServiceImple(AccountDao accountDao){
        this.accountDao = accountDao;
    }
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public void save() {
        accountDao.save();
    }
}
