package com.pankx.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据表user的entity
 */
public class User implements Serializable {
    private Integer id;//ID
    private String username;//用户名
    private Date birthday;//生日
    private String Sex;//姓别
    private String address;//地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", Sex='" + Sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
