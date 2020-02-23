package com.pankx.Test;

import com.pankx.dao.IAccountDAO;
import com.pankx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestAccount {
    @Test
    public void testFindAll()  {

        //1.读取配置文件
        InputStream in = null;
        SqlSession sqlSession=null;
        try {
            in = Resources.getResourceAsStream("SqlMappConfig.xml");
            //2.创建SqlSessionFactory工厂类
            SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3.通过工厂生成SqlSession对象
            sqlSession = sqlsessionFactory.openSession();
            //4.通过SqlSession生成AOD的代理对象
            IAccountDAO iAccountDAO = sqlSession.getMapper(IAccountDAO.class);
            //5.通过代理对象执行方法
            List<Account> list = iAccountDAO.findAll();
            for (Account account : list){
                System.out.println(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(sqlSession != null){
                sqlSession.close();
            }
        }


    }

}
