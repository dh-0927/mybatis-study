package com.dh.bank.service;


import com.dh.bank.exceptions.MoneyNotEnough;
import com.dh.bank.exceptions.TransferException;

public interface AccountService {
    void transfer(String fromAct, String toAct, double money) throws MoneyNotEnough, TransferException;
}
