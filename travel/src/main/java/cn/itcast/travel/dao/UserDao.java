package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     */
    public User findByUsername(String username);
    /**
     * 用户保存
     */
    public void save(User user);
}
