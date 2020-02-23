package com.pankx.Test;

import com.pankx.dao.IUserDao;
import com.pankx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {
    public static void main(String arg[]){
        InputStream in = null;
        SqlSession sqlSession = null;
//        1.读取主配置文件
        try {
            in = Resources.getResourceAsStream("SqlMappConfig.xml");
//        2.创建SqlSessionFactory工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        3.使用SqlSessionFactory工厂生成功SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
//        4.使用SqlSession对象生成dao的代理对象
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
//        5.使用代理对象执行方法
            List<User> users = iUserDao.findAll();
            for(User user: users){
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
//        6.释放资源
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }
    }
}
