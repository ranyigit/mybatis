package com.rory.dao;

import com.rory.domain.QueryVo;
import com.rory.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param uid
     */
    void deleteUser(Integer uid);

    /**
     * 根据ID查询用户信息
     * @param uid
     * @return
     */
    User findById(Integer uid);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    Integer findTotal();

    /**
     * QueryVo ognl表达式
     * @param queryVo
     * @return
     */
    List<User> findUserByVo(QueryVo queryVo);
}
