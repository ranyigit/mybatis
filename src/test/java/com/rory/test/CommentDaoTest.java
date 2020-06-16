package com.rory.test;

import com.rory.dao.ICommentDao;
import com.rory.dao.IMemberAccountDao;
import com.rory.domain.Comment;
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

public class CommentDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private ICommentDao commentDao = null;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMappingConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();

        commentDao = sqlSession.getMapper(ICommentDao.class);
    }

    @After
    public void destory () throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    
    @Test
    public void testFindAll() {
        List<Comment> comments = commentDao.findAllById(1);
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }
}
