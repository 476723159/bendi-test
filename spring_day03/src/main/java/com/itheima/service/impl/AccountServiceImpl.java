package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存方法");
    }

    public void updateAccount(int i) {

    }

    public int deleteAccount() {
        return 0;
    }
}
