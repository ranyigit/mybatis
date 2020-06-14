package com.rory.test;

import com.rory.dao.IUserDao;
import com.rory.domain.QueryVo;
import com.rory.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest{
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        userDao = sqlSession.getMapper(IUserDao.class);
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
}
