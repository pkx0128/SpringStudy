package com.pankx.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplatedemo {
    public static void main(String[] arg){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/eesy");
        dataSource.setUsername("root");
        dataSource.setPassword("Pankx0128");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        jdbcTemplate.execute("INSERT INTO account VALUES(null,'aaa',1500.0)");

    }
}
