package com.dh.mybatis.mapper;

import com.dh.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    int insertByList(@Param("cars") List<Car> cars);

    int deleteByIds(@Param("ids") Long[] ids);

    List<Car> selectByChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("type") String type);

    int updateBySet(Car car);

    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("type") String type);


    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("type") String type);


    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("type") String type);

    List<Car> selectByMuchId(@Param("id1") Long id1, @Param("id2") Long id2);

    List<Car> selectLikeBrand(String brand);

    Long selectTotal();

    int insertUseGeneratedKeys(Car car);

    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();
}
