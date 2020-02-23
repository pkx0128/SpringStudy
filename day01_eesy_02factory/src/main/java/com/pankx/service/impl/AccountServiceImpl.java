package com.pankx.service.impl;

import com.pankx.factory.BeanFactory;
import com.pankx.service.AccountService;
import com.pankx.service.dao.AccountDao;
import com.pankx.service.dao.impl.AccountDaoImpl;

/**
 * 业务层接口实现类
 */
public class AccountServiceImpl implements AccountService {
//    AccountDao accountDao = new AccountDaoImpl();
    //使用工厂类创建对象
    AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    public void save() {
        accountDao.saveAccount();
    }
}
