package cn.itheima.dao;

import cn.itheima.domain.User;

import java.util.List;

public interface IUser {
    List<User> findAll();
}
