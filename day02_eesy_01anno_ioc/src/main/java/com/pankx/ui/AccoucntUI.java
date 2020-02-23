package com.pankx.ui;

import com.pankx.Dao.AccountDao;
import com.pankx.Dao.impl.AccountDaoImpl;
import com.pankx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccoucntUI {

    public static void main(String arg[]){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        AccountService accountService2 = applicationContext.getBean("accountService",AccountService.class);
        System.out.println(accountService);
        System.out.println(accountService2);
//        accountService.save();
//        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDaoImpl.class);
//        accountDao.save();
        applicationContext.close();
    }

}
