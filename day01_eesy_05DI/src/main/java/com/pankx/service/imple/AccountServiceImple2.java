package com.pankx.service.imple;


import com.pankx.service.AccountService;

import java.util.Date;

public class AccountServiceImple2 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("执行了AccountServiceImple中的save方法"+"name"+this.name+" age:"+this.age+"birthday"+this.birthday);
    }
}
