package test;

import com.pankx.configuration.SpringConfiguration;
import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import com.pankx.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试
 *      spring整合junit的配置
 *      1.导入spring整合junit的jar
 *      2.使用Junit提供的一个注解把原来的mian方法替换了，替换成spring提供的@RunWith
 *      3.@ContextConfiguration注解
 *          属性：locations:指定xml文件的位置，加上classpath关键字
 *                classes:指定注解类所在的位置
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestService {

    @Autowired
    AccountService accountService;

    @Test
    public void testfindall(){
        List<Account> list = accountService.findAllAccount();
            for(Account a : list){
                System.out.println(a);
            }
    }
    @Test
    public void testfindById(){
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testsaveAccount(){
        Account account = new Account();
        account.setName("pankx");
        account.setMoney(1024);
        accountService.saveAccount(account);
    }

    @Test
    public void testupdateAccount(){
        Account account = new Account();
        account.setId(1);
        account.setName("updateaaa");
        account.setMoney(1024);
        accountService.updateAccount(account);
    }

    @Test
    public void testdeleteAccountById(){
        accountService.deleteAccountById(3);
    }
}
