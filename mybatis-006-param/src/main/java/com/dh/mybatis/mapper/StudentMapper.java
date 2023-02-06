package com.dh.mybatis.mapper;

import com.dh.mybatis.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    @MapKey("id")
    Map<String, Map<String, Object>> selectAllRetBigMap();

    Map<String, Object> selectByIdRetMap(Long id);

    List<Map<String, Object>> selectAllRetMpa();
    List<Student> selectById(Long id);

    List<Student> selectByNameAndSex(@Param("name")String name, @Param("sex")Character sex);
}
