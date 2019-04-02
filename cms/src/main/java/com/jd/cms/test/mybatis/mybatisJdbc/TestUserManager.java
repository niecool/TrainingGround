package com.jd.cms.test.mybatis.mybatisJdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author zhaochengye
 * @date 2019/4/2 15:34
 */
public class TestUserManager {
    private static SqlSession sqlSession;

    private static TestUserDao testUserDao;

    /**
     *
     */

    public static void initConnection() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = ssf.openSession();
        testUserDao = sqlSession.getMapper(TestUserDao.class);
    }


    public static void main(String[] args) throws IOException {
        initConnection();
        List<TestUser> l = testUserDao.selectAllTestUser();
        System.out.println(l.iterator().next().getName());
    }

    /**
     *
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    public void testTransaction(){

    }
}
