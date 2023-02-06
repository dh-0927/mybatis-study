package com.dh.mybatis.mapper;

import com.dh.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CarMapper {

    @Delete("delete from t_car where id = #{id}")
    int deleteByPrimaryKey(Long id);

    @Insert("insert into t_car values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})")
    int insert(Car car);

    Car selectByPrimaryKey(Long id);

    @Select("select * from t_car")
    List<Car> selectAll();

    @Update("update t_car set car_num = #{carNum}, brand = #{brand}, guide_price = #{guidePrice}, " +
            "produce_time = #{produceTime}, car_type = #{carType}")
    int updateByPrimaryKey(Car row);
}