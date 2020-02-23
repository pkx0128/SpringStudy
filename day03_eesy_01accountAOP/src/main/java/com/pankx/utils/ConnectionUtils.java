package com.pankx.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    /**
     * 获取当前线程的链接
     * @return Connection返回链接
     */
    public Connection getConnection(){
        Connection conn = tl.get();
        if(conn == null){
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 将链接与线程解绑
     */
    public void removeConnection(){
        tl.remove();//将链接释放
    }

}
