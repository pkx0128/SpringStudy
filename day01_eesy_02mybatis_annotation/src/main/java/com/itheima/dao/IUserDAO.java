package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *用户持久层接口
 */
public interface IUserDAO {
    /**
     *查询所有操作
     * @return
     */
    @Select("select id,username,sex,address from user")
   public List<User> getAll();

}
