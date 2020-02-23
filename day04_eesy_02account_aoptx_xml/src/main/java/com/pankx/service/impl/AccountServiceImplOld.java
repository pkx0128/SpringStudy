package com.pankx.service.impl;

import com.pankx.dao.IAccountDao;
import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import com.pankx.utils.TransactionManager;

import java.util.List;

/**
 * 账号的业务层实现类
 * 事务控制应该在业务层
 */
public class AccountServiceImplOld implements AccountService {

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    /**
     * accountDao的Set方法
     * @param accountDao
     */
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(TransactionManager transactionManager){
        this.transactionManager=transactionManager;
    }

    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAllAccount() {
        try{
//        1.启用事务
            transactionManager.beginTransaction();
//        2.执行操作
            List<Account> list = accountDao.findAllAccount();
//        3.提交事务
            transactionManager.commint();
//        4.返回结果
            return list;
        }catch (Exception e){
//        5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException();
        }finally{
//        6.关闭链接
            transactionManager.release();
        }
    }

    /**
     * 根据ID查询账号信息
     * @param id
     * @return
     */
    public Account findAccountById(Integer id) {
        try{
//            1.开启事务
            transactionManager.beginTransaction();
//            2.执行操作
            Account account = accountDao.findAccountById(id);
//            3.提交事务
            transactionManager.commint();
//            4.返回结果
            return account;
        }catch(Exception e){
//            5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException();
        }finally{
//            6.关闭链接
            transactionManager.release();
        }
    }

    /**
     * 保存账号信息
     * @param account
     */
    public void saveAccount(Account account) {
        try{
//            1.开启事务
            transactionManager.beginTransaction();
//            2.执行操作
            accountDao.saveAccount(account);
//            3.提交事务
            transactionManager.commint();
        }catch(Exception e){
//            4.事务回滚
            transactionManager.rollback();
        }finally{
//            5.关闭链接
            transactionManager.release();
        }
    }

    /**
     * 更新账号信息
     * @param account
     */
    public void updateAccount(Account account) {
        try{
//            1.开启事务
            transactionManager.beginTransaction();
//            2.执行操作
            accountDao.updateAccount(account);
//            3.提交事务
            transactionManager.commint();
        }catch (Exception e){
//            4.事务回滚
            transactionManager.rollback();
        }finally{
//            5.关闭链接
            transactionManager.release();
        }
    }

    /**
     * 根据ID删除账号信息
     * @param id
     */
    public void deleteAccountById(Integer id) {
        try{
//            1.开启事务
            transactionManager.beginTransaction();
//            2.执行操作
            accountDao.deleteAccountById(id);
//            3.提交事务
            transactionManager.commint();
        }catch (Exception e){
//            4.事务回滚
            transactionManager.rollback();
        }finally{
//            5.关闭链接
            transactionManager.release();
        }
    }

    /**
     * 转账号方法
     * @param sourceName 转出帐户
     * @param targetName 转入账户
     * @param money 金额
     */
    public void transfer(String sourceName, String targetName, float money) {
        try{
//            1.开启事务
            transactionManager.beginTransaction();
//            2.执行操作
    //      获取转出账号对象
            Account source = accountDao.getAccountByName(sourceName);
    //        获取转入账号对象
            Account target = accountDao.getAccountByName(targetName);
            if(source.getMoney()<money){
                throw new RuntimeException("余额不足！！");
            }
    //        转出账号减钱
            source.setMoney(source.getMoney()-money);
    //        转入账号加钱
            target.setMoney(target.getMoney() + money);
    //        更新转出账号
//             int b=1/0;
            accountDao.updateAccount(source);
    //        更新转入账号
            accountDao.updateAccount(target);
    //        }
//            3.提交事务
            transactionManager.commint();
        }catch (Exception e){
//            4.回滚事务
            transactionManager.rollback();
            e.printStackTrace();
        }finally{
//            5.关闭链接
            transactionManager.release();
        }



    }
}
