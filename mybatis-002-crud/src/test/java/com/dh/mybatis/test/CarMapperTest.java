package com.dh.mybatis.test;

import com.dh.mybatis.pojo.Car;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);
        sqlSession.close();
    }
    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(40L, "9999", "凯美瑞", 30.3, "1999-11-21", "燃油车");
        int count = sqlSession.update("updateById", car);
        System.out.println("修改了" + count + "条记录。。。");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car();
        car.setId(20L);
        int count = sqlSession.delete("deleteById", car);
        System.out.println("删除了" + count + "条记录 ...");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCarByPojo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2022-12-23", "新能源");
        sqlSession.insert("insertCar", car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar() {
        Map<String, Object> map = new HashMap<>();
        map.put("car_num", "1111");
        map.put("brand", "比亚迪汉");
        map.put("guide_price", "10.00");
        map.put("produce_time", "2020-11-11");
        map.put("car_type", "电车");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }
}
