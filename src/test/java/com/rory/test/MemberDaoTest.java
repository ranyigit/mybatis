package com.rory.test;

import com.rory.dao.IMemberDao;
import com.rory.domain.Member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MemberDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IMemberDao memberDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        memberDao = sqlSession.getMapper(IMemberDao.class);
    }

    @After
    public void destory () throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    
    @Test
    public void testFindAll() {
        List<Member> members = memberDao.findAll();
        for (Member member : members) {
            System.out.println(member);
            System.out.println(member.getMemberAccount());
            System.out.println(member.getComments());
        }
    }
}
