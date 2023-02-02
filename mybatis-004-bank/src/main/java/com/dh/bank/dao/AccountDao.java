package com.dh.bank.dao;

import com.dh.bank.pojo.Account;

public interface AccountDao {
    //根据账户号查询余额
    Account selectByActNo(String actNo);
    //根据账户号修改余额
    int updateByActNo(Account account);
}
