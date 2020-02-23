package test;

import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestService {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);

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
