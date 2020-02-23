package com.pankx.dao;

import com.pankx.domain.User;

import java.util.List;

/**
 *用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return 返回所有用户信息
     */
    public List<User> findAll();

    /**
     * 根据id查询一个用户
     * @param userid
     */
    public User findById(Integer userid);

    /**
     * 通过userName模糊查询
     * @return
     */
    public List<User> findByUserName(String name);

}
