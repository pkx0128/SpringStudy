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
     * 保存用户信息
     * @param user
     */
    public void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userid
     */
    public void deleteUser(Integer userid);

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


    /**
     * 查询总记录条数
     * @return
     */
    public int findtotal();

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    public List<User> findByconditon(User user);

}
