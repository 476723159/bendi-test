package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoIml;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl  implements UserService {

    private UserDao dao = new UserDaoIml();
    @Override
    public boolean regist(User user) {
        System.out.println("service进");
        User u = dao.findByUsername(user.getUsername());
        if(u != null){
            return false;
        }
        dao.save(user);
        System.out.println("service出");
        return true;
    }

}
