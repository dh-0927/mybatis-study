package com.dh.mybatis.mapper;

import com.dh.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    Student selectByIdStep1(Integer sid);

    Student selectById(Integer sid);

    List<Student> selectByCid(Integer cid);

}
