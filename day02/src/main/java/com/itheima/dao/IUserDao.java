package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    //根据id查询
    User findById(Integer id);


}
