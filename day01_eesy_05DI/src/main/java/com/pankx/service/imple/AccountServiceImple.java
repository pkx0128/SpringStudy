package com.pankx.service.imple;


import com.pankx.service.AccountService;

import java.util.Date;

public class AccountServiceImple implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImple(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("执行了AccountServiceImple中的save方法"+"name"+this.name+" age:"+this.age+"birthday"+this.birthday);
    }
}
