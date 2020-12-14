package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public User getUserInformation(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findUserByUseridAndUsername(Integer userId, String username) {
        return userDao.selectByIdOrUsername(userId,username);
    }

    @Override
    public boolean addUser(User user) {
        user.setCreateTime(new Date());
        user.setLastEditTime(new Date());
        int insert = userDao.insert(user);
        return insert > 0;
    }

    @Override
    public boolean modifyUser(User user) {
        if(user.getId() == null){
            return false;
        }
        user.setUsername(null);
        user.setPassword(null);
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public boolean delete(Integer userId) {
        return userDao.deleteByPrimaryKey(userId) > 0;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
