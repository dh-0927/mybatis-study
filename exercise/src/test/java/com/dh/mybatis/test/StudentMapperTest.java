package com.dh.mybatis.test;


import com.dh.mybatis.pojo.Student;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Student student = new Student(null, "小李", 32, "抚州市王安石大道");
        int count = sqlSession.insert("t_student.insertStudent", student);
        System.out.println("插入了" + count + "条记录。。。");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("t_student.deleteById", 6);
        System.out.println("删除了" + count + "条记录。。。");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Student student = new Student(6, "林锐", 19, "南昌市西湖区");
        int count = sqlSession.update("t_student.updateById", student);
        System.out.println("修改了" + count + "条记录。。。");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object student = sqlSession.selectOne("t_student.selectById", 1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> students = sqlSession.selectList("t_student.selectAll");
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
}

