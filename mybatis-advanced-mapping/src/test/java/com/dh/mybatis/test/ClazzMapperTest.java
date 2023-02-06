package com.dh.mybatis.test;

import com.dh.mybatis.mapper.ClazzMapper;
import com.dh.mybatis.pojo.Clazz;
import com.dh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {
    @Test
    public void testSelectByStep() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByIdStep1(1001);
        System.out.println(clazz.getCname());
        SqlSessionUtil.close(sqlSession);
    }
    @Test
    public void testSelectByConnection() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByConnection(1001);
        System.out.println(clazz);
        SqlSessionUtil.close(sqlSession);
    }
}
