package com.rory.test;

import com.rory.dao.IMemberAccountDao;
import com.rory.dao.IMemberDao;
import com.rory.domain.Member;
import com.rory.domain.MemberAccount;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MemberAccountDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IMemberAccountDao memberAccountDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        memberAccountDao = sqlSession.getMapper(IMemberAccountDao.class);
    }

    @After
    public void destory () throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    
    @Test
    public void testFindAll() {
        MemberAccount memberAccount = memberAccountDao.findById(1);
        System.out.println(memberAccount);
    }
}
