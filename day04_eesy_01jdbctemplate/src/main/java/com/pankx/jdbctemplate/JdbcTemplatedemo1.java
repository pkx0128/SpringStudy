package com.pankx.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplatedemo1 {
    public static void main(String[] arg){
//        获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
//          执行方法
        jdbcTemplate.execute("INSERT INTO account VALUES(null,'aaa',1500.0)");

    }
}
