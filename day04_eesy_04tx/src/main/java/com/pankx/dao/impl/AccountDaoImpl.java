package com.pankx.dao.impl;

import com.pankx.dao.IAccountDao;
import com.pankx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * 根据id查找账号
     *
     * @param id
     * @return Account
     */
    public Account findAccountById(Integer id) {
        List<Account> list = jdbcTemplate.query("SELECT * FROM account WHERE id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return list.get(0);
    }

    /**
     * 根据名字查询徽号
     *
     * @param name
     * @return
     */
    public Account getAccountByName(String name) {
        List<Account> list = jdbcTemplate.query("SELECT * FROM account WHERE name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果不唯一");
        }
        return list.get(0);
    }

    /**
     * 更新账号信息
     *
     * @param account
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE account SET name=?,money=? WHERE id=?",account.getName(),account.getMoney(),account.getId());

    }
}
