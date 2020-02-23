package com.pankx.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包括开启，提交，回滚，关闭事物
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    @Pointcut("execution(* com.pankx.service.impl.*.*(..))")
    public void pt1(){}

    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction(){
        try {
            //把提交事务设置成手动
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commint(){
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务
     */@After("pt1()")
    public void release(){
        try {
            connectionUtils.getConnection().close();//将链接还回链接池
            connectionUtils.removeConnection();//将链接与线程解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
