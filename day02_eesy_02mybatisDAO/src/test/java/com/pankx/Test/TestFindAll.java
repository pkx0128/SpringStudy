package com.pankx.Test;

import com.pankx.dao.IUserDao;
import com.pankx.dao.impl.IUserDaoImpl;
import com.pankx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestFindAll {
        InputStream in = null;
        SqlSession sqlSession = null;
        IUserDaoImpl iUserDao = null;

        @Before
        public void init() throws IOException {
//        1.读取配置文件
            in = Resources.getResourceAsStream("SqlMappConfig.xml");
////        2.创建SqlSessoinFactory工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
////        3.用SqlSessionFactory工厂生成SqlSession对象
            sqlSession = sqlSessionFactory.openSession();

        }
        @After
        public void destory() throws IOException {
            sqlSession.commit();

            if (in != null) {
                in.close();
            }
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        @Test
        public void testFindAll() {
            iUserDao = new IUserDaoImpl(sqlSession);
            List<User> users = iUserDao.findAll();
            for (User user : users) {
                System.out.println(user);
            }
        }

        @Test
        public void testSave(){
            iUserDao = new IUserDaoImpl(sqlSession);
            User user = new User();
            user.setUsername("pankximple");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("广东茂名");

            iUserDao.saveUser(user);
            System.out.println(user);
        }
    @Test
    public void testUpdateUser(){
            iUserDao = new IUserDaoImpl(sqlSession);
            User user = new User();
            user.setId(14);
            user.setUsername("pankxupdate");
            user.setSex("女");
            user.setAddress("广东深圳2");
            iUserDao.updateUser(user);
    }
    @Test
    public void testDeleteUser(){
            iUserDao = new IUserDaoImpl(sqlSession);
            iUserDao.deleteUser(13);
    }
    @Test
    public void testFindById(){
            iUserDao = new IUserDaoImpl(sqlSession);
           User user =  iUserDao.findById(14);
           System.out.println(user);

    }

    @Test
    public void testFindByUserName(){
            iUserDao = new IUserDaoImpl(sqlSession);
            List<User> users = iUserDao.findByUserName("%update%");
            for(User user : users){
                System.out.println(user);
            }

    }
    @Test
    public void testFindtotal(){
            iUserDao = new IUserDaoImpl(sqlSession);
            int count = iUserDao.findtotal();
            System.out.println(count);

    }



}
