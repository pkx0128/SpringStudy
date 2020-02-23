package com.pankx.ui;

import com.pankx.service.AccountService;
import com.pankx.service.imple.AccountServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccoucntUI {

    public static void main(String arg[]){
//        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
//        AccountService accountService1 = applicationContext.getBean("accountService",AccountService.class);
        System.out.println("accountService hashCode:"+accountService.hashCode());
//        System.out.println("accountService hashCode:"+accountService1.hashCode());
//        accountService.save();
        applicationContext.close();
    }
    
}
