package com.rory.dao;

import com.rory.domain.QueryVo;
import com.rory.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有，同时获取到用户下所有账户的信息
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

    /**
     * 根据传入参数条件查询
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserByIds(QueryVo vo);
}
