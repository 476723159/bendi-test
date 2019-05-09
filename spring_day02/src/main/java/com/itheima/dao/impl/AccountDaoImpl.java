package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.doamin.Account;
import com.itheima.util.ConnectUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
//@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    private ConnectUtils connectionUtils;
    public void setConnectUtils(ConnectUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //@Autowired


    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount()  {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Account findById(Integer id) {
        try{
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void deleteAccount(Integer id) {
        try{
            runner.update("delete from account where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Account findByName(String accountName) {
        try{
            List<Account> accounts= runner.query("select * from account where name = ?",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() ==0){
                return  null;
            }
            if(accounts.size()>1){
                throw new RuntimeException("结果集不唯一,数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
