package com.pankx.ui;

import com.pankx.factory.BeanFactory;
import com.pankx.service.AccountService;
import com.pankx.service.impl.AccountServiceImpl;

public class AcountUI {

    public static void main(String[] args) {
//        AccountService accountService = new AccountServiceImpl();
//        使用工厂类创建对象
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        accountService.save();
    }
}
