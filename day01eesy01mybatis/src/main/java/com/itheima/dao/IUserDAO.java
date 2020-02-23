package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 *用户持久层接口
 */
public interface IUserDAO {
    /**
     *查询所有操作
     * @return
     */
   public List<User> getAll();

}
