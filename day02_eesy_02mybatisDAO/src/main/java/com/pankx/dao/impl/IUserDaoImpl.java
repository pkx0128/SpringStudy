package com.pankx.dao.impl;

import com.pankx.dao.IUserDao;
import com.pankx.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private SqlSession sqlSession;
    public IUserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    /**
     * 查询所有数据￿
     * @return
     */
    public List<User> findAll() {
        List<User> user = sqlSession.selectList("com.pankx.dao.IUserDao.findAll");
        return user;
    }

    /**
     * 插入数据
     * @param user
     */
    public void saveUser(User user) {
        sqlSession.insert("com.pankx.dao.IUserDao.saveUser",user);
    }

    /**
     * 更新数据
     * @param user
     */
    public void updateUser(User user) {
        sqlSession.update("com.pankx.dao.IUserDao.updateUser",user);
    }

    /**
     * 根据id删除数据
     * @param userid
     */
    public void deleteUser(Integer userid) {
        sqlSession.delete("com.pankx.dao.IUserDao.deleteUser",userid);
    }

    public User findById(Integer userid) {
        User user = sqlSession.selectOne("com.pankx.dao.IUserDao.findById",userid);
        return user;
    }

    public List<User> findByUserName(String name) {

        List<User> list = sqlSession.selectList("com.pankx.dao.IUserDao.findByUserName","%"+name+"%");
        return list;
    }

    public int findtotal() {
        int cout = sqlSession.selectOne("com.pankx.dao.IUserDao.findtotal");
        return cout;
    }
}
