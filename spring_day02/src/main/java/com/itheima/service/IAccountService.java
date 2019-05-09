package com.itheima.service;

import com.itheima.doamin.Account;

import java.util.List;

public interface IAccountService {
    //查询所有
    List<Account> findAllAccount();
    //根据id查询
    Account findById(Integer id);
    //保存
    void saveAccount(Account account);
    //删
    void deleteAccount(Integer id);
    //改
    void updateAccount(Account account);
    //转账
    void transferMoney(String sourceName,String targetName,Float money);
}
