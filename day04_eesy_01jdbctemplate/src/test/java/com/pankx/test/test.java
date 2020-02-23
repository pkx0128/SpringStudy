package com.pankx.test;

import com.pankx.dao.IAccoutDao;
import com.pankx.dao.impl.AccountDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] arg){
//        获取ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        获取对象
        IAccoutDao accountDao = applicationContext.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(accountDao.findById(8));
    }
}
