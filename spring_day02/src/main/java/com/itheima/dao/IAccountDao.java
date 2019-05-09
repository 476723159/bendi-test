package com.itheima.dao;

import com.itheima.doamin.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    //查询所有
    List<Account> findAllAccount() ;
    //根据id查询
    Account findById(Integer id);
    //保存
    void saveAccount(Account account);
    //删
    void deleteAccount(Integer id);
    //改
    void updateAccount(Account account);
    //根据用户查询账户信息
    Account findByName(String accountName);
}
