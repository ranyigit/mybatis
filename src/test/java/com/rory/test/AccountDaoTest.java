package com.rory.test;

import com.rory.dao.IAccountDao;
import com.rory.dao.IUserDao;
import com.rory.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory () throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 一对一延迟加载测试
     */
    @Test
    public void testFindOneByOne() {
        List<Account> accounts= accountDao.findOneByOne();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
