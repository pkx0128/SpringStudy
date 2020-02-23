package com.pankx.service.impl;

import com.pankx.Dao.AccountDao;
import com.pankx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.sql.SQLOutput;

/**
 * 业务实现类
 * 曾经的xml配置：
 * <bean id="accountService" class="com.pankx.service.impl.AccountServiceImple" scope="" init-method="" destory-method="" >
 *     注解分为四类
 *          1.用于创建对象
 *              相当于xml配置文件中的bean标签的实现功能
 *              @Component
 *                  作用：把当前类的对象存入spring容器中
 *                  属性：value 用于指定对象的id，当不设置value值时对象的id为当前类名且改首字母为小写
 *              @Controller:
 *                          主要用于表现层
 *              @Service:
 *                          主要用于业务层
 *              @Repository:
 *                          主要用于持久层
 *                  以上三个注解的功能与@Component注解的功能完全一样，使用主要用于三层结构开发使用的注解，使用结构清晰
 *
 *          2.用于注入数据
 *              相当于xml配置文件中的bean标签下的property标签的功能
 *              @Autowired:
 *                  作用：
 *                      自动按照类型注入。主要容器中有唯一的bean类型和要注入的类型匹配，就可以注入成功
 *                      如果ioc容器中没有bean类型与要注入的数据类型匹配就报错
 *                      如果ioc容器中有多个bean类型与要注入的数据类型匹配：如果注入类型的变量名与ioc容器中的bean的名字相同则可以注入成功否则注入失败
 *                  使用位置：
 *                         可以使用在变量上，也可以使用在方法上
 *                  使用细节：
 *                          在使用注解时，set方法就不是必须的了
 *              @Qulifier:
 *                  作用：
 *                      在按照类中的注入之上按照名称注入，在类成员变量注入时不能单独使用，但在方法中参数注入可以单独使用
 *                  属性：
 *                      value:指定注入bean的id
 *              @Resource:
 *                  作用：
 *                      直接指bean的id注入
 *                  属性：
 *                      name:指定注入bean的id
 *               以上三个注解只能注入其他bean类型的数据，基本数据类型和String类型注入无法实现，集合类型数据注入只能通过xml方式实现
 *
 *              @Value:
 *                  作用：
 *                      用于基本数据类型和String类型的值注入
 *                  属性：
 *                      value：用于指定注入数据的值，可以使用spring中的SpEl(也就是spring中的EL表达式）
 *                              SpEl表达式写法：${表达式}
 *
 *          3.用于改变作用域
 *              相当于xml配置文件中的 bean标签中的 scope 属性的功能
 *              @Scope:
 *                  作用：
 *                      用于指定bean的作用范围
 *                  属性：
 *                      value:用于指定范围的取值 常用取值：signleton,property
 *          4.用于改变生命周期
 *              相当于xml配置文件中的bean标签中的init-method和destory-method属性的功能
 *              @PreDestroy:
 *                  作用：
 *                      用于指定销毁方法
 *              @PostConstruct:
 *                  作用：
 *                      用于指定初始化方法
 */
@Service("accountService")
@Scope(value = "singleton")
public class AccountServiceImple implements AccountService {
//    @Autowired
//    @Qualifier(value = "accountDao1")
//    @Resource(name = "accountDao1")
    @Resource(name="accountDao2")
    AccountDao accountDao1;
    public void save() {
        System.out.println("AccountServiceImple save method running");
        accountDao1.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("这是初始化方法");
    }
    @PreDestroy
    public void destory(){
        System.out.println("这是销毁方法");
    }
}
