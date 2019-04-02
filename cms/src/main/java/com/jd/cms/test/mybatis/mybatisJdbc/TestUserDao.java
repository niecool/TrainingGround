package com.jd.cms.test.mybatis.mybatisJdbc;

import java.util.LinkedList;

/**
 * @author zhaochengye
 * @date 2019/4/2 15:33
 */
public interface TestUserDao {

    public LinkedList<TestUser> selectAllTestUser();
}
