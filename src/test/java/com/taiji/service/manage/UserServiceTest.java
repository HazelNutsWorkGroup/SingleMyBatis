package com.taiji.service.manage;

import com.taiji.common.util.SnowflakeIdWorker;
import com.taiji.domain.manage.UserDomain;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sleeb on 2017/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private static SnowflakeIdWorker snowflakeIdWorker;

    @BeforeClass
    public static void initializeClass() {
        snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
    }

    @Test
    public void TestGetUser(){
        UserDomain userDomain=userService.getUser(1L);

        Assert.assertEquals("Test001",userDomain.getUserName());
    }
}

