package com.rory.test;

import com.rory.dao.IAccountDao;
import com.rory.dao.IUserDao;
import com.rory.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest{
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao = null;
    private IAccountDao accountDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        userDao = sqlSession.getMapper(IUserDao.class);

        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory () throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAllTest() throws Exception{

        List<User> users = userDao.findAll();

        for(User user : users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("上海市浦东新区");

        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("上海市浦东新区");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(4);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void findUserName(){
        List<User> users = userDao.findByName("%三%");
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println("总用户数："+total);
    }

    @Test
    public void findUserByVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%张%");
        queryVo.setUser(user);
        List<User> users = userDao.findUserByVo(queryVo);
        for (User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindCondition() {
        User user = new User();
        user.setUsername("老王");
        List<User> users = userDao.findUserByCondition(user);
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindByIds() {
        QueryVo queryVo = new QueryVo();

        List ids = new ArrayList();
        ids.add(1);
        ids.add(3);
        queryVo.setIds(ids);

        List<User> users = userDao.findUserByIds(queryVo);
        for(User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void tesFindAccount() {
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 测试查询所有账户，同时包含用户名和地址
     */
    @Test
    public void testFindAll() {
        List<AccountUser> accountUsers = accountDao.findAllUserAccount();
        for(AccountUser accountuser : accountUsers) {
            System.out.println(accountuser);
        }
    }

    @Test
    public void testFindAllRole(){
        List<User> users = userDao.findAllRole();
        for (User user : users){
            System.out.println(user);
            System.out.println(user.getRoles());

            System.out.println("-----------------");
        }
    }

}
