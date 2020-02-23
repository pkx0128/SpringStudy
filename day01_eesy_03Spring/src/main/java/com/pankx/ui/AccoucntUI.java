package com.pankx.ui;

import com.pankx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccoucntUI {

    public static void main(String arg[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
//        AccountService accountService =  new AccountServiceImple();
        accountService.save();
    }

}
