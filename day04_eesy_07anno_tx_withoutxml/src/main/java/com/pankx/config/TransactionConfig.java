package com.pankx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 事务管理相关配置类
 */
public class TransactionConfig {
    /**
     * 创建事务管理对象
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransacitonManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
