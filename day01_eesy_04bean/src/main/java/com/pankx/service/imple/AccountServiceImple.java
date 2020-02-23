package com.pankx.service.imple;


import com.pankx.service.AccountService;

public class AccountServiceImple implements AccountService {
    public AccountServiceImple(){
        System.out.println("对象创建了");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destory(){
        System.out.println("对象被销毁了");
    }
    public void save() {
        System.out.println("保存了");
    }
}
