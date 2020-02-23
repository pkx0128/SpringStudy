package com.pankx.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包括开启，提交，回滚，关闭事物
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        System.out.println("开启事务");
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
    public void commint(){
        System.out.println("提交事务");
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        System.out.println("回滚事务");
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭事务
     */
    public void release(){
        System.out.println("关闭事务");
        try {
            connectionUtils.getConnection().close();//将链接还回链接池
            connectionUtils.removeConnection();//将链接与线程解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
