package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.doamin.Account;
import com.itheima.service.IAccountService;
import com.itheima.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    //@Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            //提交
            txManager.commit();
            //返回结果
            return allAccount;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
//        return accountDao.findAllAccount();
    }

    public Account findById(Integer id) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            Account account=accountDao.findById(id);
            //提交
            txManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.saveAccount(account);
            //提交
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.deleteAccount(id);
            //提交
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.updateAccount(account);
            //提交
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void transferMoney(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            //提交
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }


    }
}
