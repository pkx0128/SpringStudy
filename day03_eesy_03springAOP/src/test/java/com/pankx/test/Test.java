package com.pankx.test;

import com.pankx.service.IAccountService;
import com.pankx.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String arg[]){
//        获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        获取对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.updateAccount(1);
        accountService.deleteAccount();





    }
}
