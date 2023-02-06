package com.dh.mybatis.test;

import com.dh.mybatis.mapper.CarMapper;
import com.dh.mybatis.pojo.Car;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {

//    SqlSession sqlSession = SqlSessionUtil.openSession();
//    CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//
//    SqlSessionUtil.close(sqlSession);


    @Test
    public void testInsertByList() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(null, "1000", "红旗1", 99.9, "2022-10-01", "燃油车");
        Car car2 = new Car(null, "1001", "红旗2", 99.9, "2022-10-01", "燃油车");
        Car car3 = new Car(null, "1002", "红旗3", 99.9, "2022-10-01", "燃油车");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        mapper.insertByList(cars);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {98L, 99L, 100L};
        mapper.deleteByIds(ids);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByChoose() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//        List<Car> cars = mapper.selectByChoose("比亚迪", 5.0, "电车");
        List<Car> cars = mapper.selectByChoose("", null, "");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateBySet() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(96L, "9910", null, 0.0, null, null);
        System.out.println("更新了" + mapper.updateBySet(car) + "条记录");
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim("比亚迪", 5.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("比亚迪", null, "");
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 10.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("", 10.0, "");
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 10.0, "");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//        List<Car> cars = mapper.selectByMultiCondition("比亚迪", 5.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("比亚迪", null, "");
        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 10.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("", 10.0, "");
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 10.0, "");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
//        List<Car> cars = mapper.selectByMultiCondition("比亚迪", 5.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("比亚迪", null, "");
//        List<Car> cars = mapper.selectByMultiCondition("", 10.0, "电车");
//        List<Car> cars = mapper.selectByMultiCondition("", 10.0, "");
        List<Car> cars = mapper.selectByMultiCondition("比亚迪", 10.0, "");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMuchId() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMuchId(1L, 2L);
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectLikeBrand() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectLikeBrand("特斯拉");
        cars.forEach(car -> System.out.println(car));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectTotal() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total = mapper.selectTotal();
        System.out.println("一共有" + total + "辆车...");
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertUseGeneratedKeys () {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "9991", "凯美瑞", 28.8, "2020-11-18", "燃油车");
        mapper.insertUseGeneratedKeys(car);
        Car car2 = new Car(car.getId(), "9997", "凯美瑞", 28.8, "2020-11-18", "燃油车");
        mapper.update(car2);
        System.out.println(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "0001", "特斯拉", 44.4, "2022-09-28", "新能源");
        mapper.insert(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteById(86L);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(87L, "1111", "特斯拉", 24.4, "2012-09-28", "电车");
        mapper.update(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(1L);
        System.out.println(car);
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
