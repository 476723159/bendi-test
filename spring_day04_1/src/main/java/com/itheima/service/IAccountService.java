package com.itheima.service;

import com.itheima.domain.Account;

public interface IAccountService {

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
