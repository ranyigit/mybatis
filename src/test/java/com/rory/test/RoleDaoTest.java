package com.rory.test;

import com.rory.dao.IRoleDao;
import com.rory.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleDaoTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);

        sqlSession = sqlSessionFactory.openSession(true);

        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destory() throws Exception{
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles){
            System.out.println(role);

            System.out.println(role.getUsers());

            System.out.println("----------------");
        }
    }
}
