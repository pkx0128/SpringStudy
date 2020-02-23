package com.pankx.dao.impl;

import com.pankx.dao.IAccountDao;
import com.pankx.domain.Account;
import com.pankx.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account findAccountById(Integer id) {
        try {
            return queryRunner.query( connectionUtils.getConnection(),"select id,name,money from account where id=?", new BeanHandler<Account>(Account.class),id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update( connectionUtils.getConnection(),"insert into account (name,money)VALUES(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update( connectionUtils.getConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccountById(Integer id) {
        try {
            queryRunner.update( connectionUtils.getConnection(),"delete from account where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account  getAccountByName(String name) {

        try {
            List<Account> account = queryRunner.query( connectionUtils.getConnection(),"select * from account where name=?", new BeanListHandler<Account>(Account.class),name);
            if (account.size()==0 || account==null){
                return null;
            }
            if (account.size() > 1) {
                throw new RuntimeException("用户名为唯一，数据错误");
            }
            return account.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
