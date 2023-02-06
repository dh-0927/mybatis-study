package com.dh.mybatis.mapper;

import com.dh.mybatis.pojo.Clazz;

public interface ClazzMapper {

    Clazz selectByConnection(Integer cid);

    Clazz selectByIdStep2(Integer cid);

    Clazz selectByIdStep1(Integer cid);
}
