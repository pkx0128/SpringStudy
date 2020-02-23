package com.pankx.service.impl;

import com.pankx.dao.IAccountDao;
import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import com.pankx.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号的业务层实现类
 * 事务控制应该在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private IAccountDao accountDao;

    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAllAccount() {
        List<Account> list = accountDao.findAllAccount();
        return list;

    }

    /**
     * 根据ID查询账号信息
     * @param id
     * @return
     */
    public Account findAccountById(Integer id) {
            Account account = accountDao.findAccountById(id);
            return account;
    }

    /**
     * 保存账号信息
     * @param account
     */
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    /**
     * 更新账号信息
     * @param account
     */
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    /**
     * 根据ID删除账号信息
     * @param id
     */
    public void deleteAccountById(Integer id) {
            accountDao.deleteAccountById(id);
    }

    /**
     * 转账号方法
     * @param sourceName 转出帐户
     * @param targetName 转入账户
     * @param money 金额
     */
    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("transfer方法开始执行。。。。");
        try{
//            1.开启事务
//            transactionManager.beginTransaction();
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
//            transactionManager.commint();
        }catch (Exception e){
//            4.回滚事务
//            transactionManager.rollback();
            e.printStackTrace();
        }finally{
//            5.关闭链接
//            transactionManager.release();
        }
    }
}
