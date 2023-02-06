package com.dh.mybatis.test;

import com.dh.mybatis.mapper.StudentMapper;
import com.dh.mybatis.pojo.Student;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void testSelectByIdStep() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(6);
        System.out.println("学生姓名：" + student.getSname());
//        System.out.println("学生班级：" + student.getClazz().getCname());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(6);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSElectByCid() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students1 = mapper.selectByCid(1001);
        System.out.println("内存地址为" + sqlSession.hashCode() + "的sqlSession查询的地址：" + students1.hashCode());
        SqlSessionUtil.close(sqlSession);

        SqlSession sqlSession1 = SqlSessionUtil.openSession();
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        List<Student> students2 = mapper1.selectByCid(1001);
        System.out.println("内存地址为" + sqlSession1.hashCode() + "的sqlSession查询的地址：" + students2.hashCode());
        SqlSessionUtil.close(sqlSession1);
    }
}
