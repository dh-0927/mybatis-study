package com.dh.bank.dao.impl;

import com.dh.bank.dao.AccountDao;
import com.dh.bank.pojo.Account;
import com.dh.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActNo(String actNo) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("t_act.selectByActNo", actNo);
        return account;
    }

    @Override
    public int updateByActNo(Account account) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("t_act.updateByActNo", account);
        return count;
    }
}
