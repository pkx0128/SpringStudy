package test;

import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestService {
    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testfindall(){
        List<Account> list = accountService.findAllAccount();
            for(Account a : list){
                System.out.println(a);
            }
    }

    @Test
    public void testTranfer(){
        accountService.transfer("pankx","bbb",500);
    }
}
