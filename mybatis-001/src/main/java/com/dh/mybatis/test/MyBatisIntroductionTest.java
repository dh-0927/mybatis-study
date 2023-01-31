package com.dh.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        // 1. 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 创建SqlSessionFactory
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);//一般情况下都是一个数据库对应一个SqlSessionFactory对象
        // 3. 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行SQL语句
        int count = sqlSession.insert("insertCar");
        System.out.println("插入了" + count + "条记录...");

        //手动提交
//        sqlSession.commit();
    }
}
