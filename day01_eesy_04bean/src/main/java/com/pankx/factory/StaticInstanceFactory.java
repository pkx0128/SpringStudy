package com.pankx.factory;

import com.pankx.service.AccountService;
import com.pankx.service.imple.AccountServiceImple;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码方式提供默认构造函数
 */
public class StaticInstanceFactory {
    /**
     *通过getAccountService方法获取AccountService对象
     * @return AccountService对象
     */
    public static AccountService getAccountService(){
        return new AccountServiceImple();
    }
}
