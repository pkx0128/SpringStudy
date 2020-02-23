package com.pankx.ui;

import com.pankx.service.AccountService;
import com.pankx.service.imple.AccountServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccoucntUI {

    public static void main(String arg[]){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService3 = applicationContext.getBean("accountService3",AccountService.class);
//        System.out.println("accountService hashCode:"+accountService.hashCode());
        accountService3.save();
    }
    
}
