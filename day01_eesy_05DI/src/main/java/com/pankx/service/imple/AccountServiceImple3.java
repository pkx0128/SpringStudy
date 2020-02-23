package com.pankx.service.imple;


import com.pankx.service.AccountService;

import java.util.*;

public class AccountServiceImple3 implements AccountService {
        private String[] myString;
        private List<String> mylist;
        private Set<String> myset;
        private Map<String,String> mymap;
        private Properties properties;

    public void setMyString(String[] myString) {
        this.myString = myString;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
        System.out.println(Arrays.toString(myString));
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(mymap);
        System.out.println(properties);
    }
}
