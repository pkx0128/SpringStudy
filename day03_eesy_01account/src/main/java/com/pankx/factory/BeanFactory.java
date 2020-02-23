package com.pankx.factory;

import com.pankx.domain.Account;
import com.pankx.service.AccountService;
import com.pankx.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }



    /**
     * 获取AccountService的代理对象
     * @return
     */
    public AccountService getAccountService(){
      AccountService proxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 实现事务控制
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object revalue=null;
                System.out.println("invoke执行。。。。");
                try{
//            1.开启事务
                    transactionManager.beginTransaction();
//            2.执行操作
//                    Account account = accountDao.findAccountById(id);
                    revalue = method.invoke(accountService,args);
//            3.提交事务
                    transactionManager.commint();
//            4.返回结果
                    return revalue;
                }catch(Exception e){
//            5.事务回滚
                    transactionManager.rollback();
                    throw new RuntimeException();
                }finally{
//            6.关闭链接
                    transactionManager.release();
                }
            }
        });
        return proxy ;
    }

}
