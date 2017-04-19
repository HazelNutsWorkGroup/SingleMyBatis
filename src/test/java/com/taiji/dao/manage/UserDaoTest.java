package com.taiji.dao.manage;

import com.taiji.entity.manage.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.Reader;

/**
 * Created by Sleeb on 2017/4/19.
 */
public class UserDaoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @BeforeClass
    public static void initializeClass() throws Exception{
        // create a SqlSessionFactory
        Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

    }

    @Before
    public void initializeField(){
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }


    @Test
    public void TestGetUser(){
        UserEntity userEntity=userDao.getUser(1L);

        Assert.assertEquals("Test001",userEntity.getUserName());
    }

    @After
    public void destructField(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
