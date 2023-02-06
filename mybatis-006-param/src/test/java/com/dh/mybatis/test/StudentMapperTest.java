package com.dh.mybatis.test;

import com.dh.mybatis.mapper.StudentMapper;
import com.dh.mybatis.pojo.Student;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentMapperTest {

    @Test
    public void testSelectAllRetBigMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Map<String, Object>> map = mapper.selectAllRetBigMap();
        System.out.println(map);
        SqlSessionUtil.close(sqlSession);

    }


    @Test
    public void testSelectAllRetMpa() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllRetMpa();
        maps.forEach(map -> System.out.println(map));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> student = mapper.selectByIdRetMap(1L);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByNameAndSex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("李思", '女');
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> System.out.println(student));
        SqlSessionUtil.close(sqlSession);

    }
}
