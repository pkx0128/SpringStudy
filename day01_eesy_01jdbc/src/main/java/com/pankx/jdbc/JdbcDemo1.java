package com.pankx.jdbc;

import java.sql.*;

public class JdbcDemo1 {

    public static void main(String[] arg) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
//        1.注册驱动
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        2.获取连接对象
        String url = "jdbc:mysql://localhost/eesy";
        String username = "root";
        String password = "Pankx0128";
        Connection connection = DriverManager.getConnection(url,username,password);
//        3.获得操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account");
//        4.获取操作结果集
        ResultSet resultSet = preparedStatement.executeQuery();
//        5.遍历结果集
        while(resultSet.next()){
            System.out.println("id:"+resultSet.getInt("id")+" name:"+resultSet.getString("name")+" money:"+resultSet.getFloat("money"));
        }
//        6释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
