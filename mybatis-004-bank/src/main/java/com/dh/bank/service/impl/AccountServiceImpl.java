package com.dh.bank.service.impl;

import com.dh.bank.dao.AccountDao;
import com.dh.bank.dao.impl.AccountDaoImpl;
import com.dh.bank.exceptions.MoneyNotEnough;
import com.dh.bank.exceptions.TransferException;
import com.dh.bank.pojo.Account;
import com.dh.bank.service.AccountService;
import com.dh.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    //    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);

    //实现完成转账的相关业务
    @Override
    public void transfer(String fromActNo, String toActNo, double money) throws MoneyNotEnough, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.getMapper(AccountDao.class);
        //首先判断转出账户余额是否充足(select)
        Account fromAct = accountDao.selectByActNo(fromActNo);
        //如果不充足，提示用户
        if (fromAct.getBalance() < money) {
            //抛出异常
            throw new MoneyNotEnough("余额不足！");
        }
        //运行到这，说明余额充足，完成转账操作(update)
        Account toAct = accountDao.selectByActNo(toActNo);

        //首先在内存中修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.updateByActNo(fromAct);
        count += accountDao.updateByActNo(toAct);

        if (count != 2) {
            //程序出现异常
            throw new TransferException("转账失败！未知原因。");
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
}
