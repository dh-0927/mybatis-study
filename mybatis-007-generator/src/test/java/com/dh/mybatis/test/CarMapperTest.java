package com.dh.mybatis.test;

import com.dh.mybatis.mapper.CarMapper;
import com.dh.mybatis.pojo.Car;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "1234", "兰博基尼", new BigDecimal(1888.8), "2015-02-12", "燃油车");
        mapper.insert(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteByPrimaryKey(101L);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(79L, "1234", "兰博基尼", new BigDecimal(1888.8), "2015-02-12", "燃油车");
        mapper.updateByPrimaryKey(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

}
