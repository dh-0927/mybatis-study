package com.dh.mybatis.test;

import com.dh.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {
    @Test
    public void testPooled() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2022-12-23", "新能源");



        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertCar", car);
            sqlSession.commit();
        }
    }

}
