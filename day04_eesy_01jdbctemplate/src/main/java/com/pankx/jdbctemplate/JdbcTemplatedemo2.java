package com.pankx.jdbctemplate;

import com.pankx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD
 */
public class JdbcTemplatedemo2 {
    public static void main(String[] arg){
//        获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);

//          执行方法
//        jdbcTemplate.execute("INSERT INTO account VALUES(null,'aaa',1500.0)");
//        增
        jdbcTemplate.update("INSERT INTO account (name,money) VALUES(?,?)","PANKX",1000);
//        删
        jdbcTemplate.update("DELETE FROM account WHERE ID=?",11);
//        改
        jdbcTemplate.update("UPDATE account SET name=? ,money=? WHERE ID = ?","PANKXUPDATE",1000,12);
//        查所有
//        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account WHERE money > ? ",new AccountRowMap(),1000);
//        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account WHERE money > ?",new BeanPropertyRowMapper<Account>(Account.class),1000);
//        for(Account account : accounts){
////            System.out.println(account.getId()+","+account.getName()+","+account.getMoney());
//            System.out.println(account);
//        }

//        查1条
        List<Account> accounts1 = jdbcTemplate.query("SELECT * FROM account WHERE id = ?",new BeanPropertyRowMapper<Account>(Account.class),11);
        System.out.println(accounts1.isEmpty() ? "没有查到值" :accounts1.get(0));
    }
}

 class AccountRowMap implements RowMapper{

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
