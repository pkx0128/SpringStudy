package com.pankx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * spring的配置类相当于bean.xml
 */
@Transactional
@ComponentScan("com.pankx")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
