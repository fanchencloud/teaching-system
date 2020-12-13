package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/13
 * @Time: 20:20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public boolean login(String username, String password, int type) {
        User user = userDao.selectByUsernameAndPassword(username, password);
        return user != null && user.getUserType() == type;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
