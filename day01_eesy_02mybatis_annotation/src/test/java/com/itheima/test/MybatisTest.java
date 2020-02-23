package com.itheima.test;

import com.itheima.dao.IUserDAO;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param arg
                */
        public static void main(String arg[]) throws IOException {
//        1.读取配置文件
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        3.使用SqlSessionFactory工厂生成SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.使用sqlSession对象生成dao接口的代理对象
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
//        5.使用代理对象执行方法
            List<User> users = userDAO.getAll();
            for(User user1 : users){
                System.out.println(user1);
            }
//        6.释放资源
            sqlSession.close();
            in.close();
    }
}
