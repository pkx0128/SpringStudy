package com.pankx.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 这是个配置类，功能与bean.xml配置文件相同
 * Spring中的新注解
 * @Configuration
 *      作用：
 *          指定当前类是一个配置类
 * @ComponentScan
 *      作用：
 *          用于通过注解指定Spring在创建容器时要扫描的包
 *      属性：
 *          value:它和basePackages的作用是一样的，都是用于指定Spring在创建容器时要扫描的包，
 *                  此注解等同于xml中的配置：
 *                      <context:component-scan base-package="com.pankx"></context:component-scan>
 * @Bean
 *      作用：用于把当前方法中的返回值作为bean对象存入到springIOC容器中
 *      属性：
 *          name:用于指定bean的id，当不写明name属性时id的名称就是方法名
 *
 * @import
 *      作用：用于导入其他配置类
 *      属性：value用于指定其他配置类的字节码，有import注解的类为父配置类，导入的类为字配置类
 * @PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：value用于指定文件名称和路径
 *          classpath:指定类的路径
 *
 */
@Configuration()
@ComponentScan(value="com.pankx")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
    @Value("${ds.Driver}")
    private String driver;
    @Value("${ds.Url}")
    private String url;
    @Value("${ds.User}")
    private String user;
    @Value("${ds.Password}")
    private String password;
    /**
     * 创建数据源对象
     * @param dataSource
     * @return QueryRunner对象
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
