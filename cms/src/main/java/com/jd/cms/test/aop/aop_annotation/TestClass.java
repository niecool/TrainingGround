package com.jd.cms.test.aop.aop_annotation;


import com.jd.cms.test.mybatis.mybatisJdbc.TestUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhaochengye
 * @date 2019/4/1 14:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class TestClass {

    @Resource
    private MyService myService;

    @Resource
    TestUserDao testUserDao;

    /**
     *
     */
    @Test
    public void test(){
        myService.doSomething();
        myService.doSomethingElse();
    }


    /**
     *
     */
    @Test
    public void testMybatis(){
        System.out.println(testUserDao.selectAllTestUser().get(0).getName());
    }
}
