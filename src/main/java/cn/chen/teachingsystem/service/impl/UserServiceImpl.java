package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.service.UserService;
import com.alibaba.druid.util.StringUtils;
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
        return userDao.selectByIdOrUsername(userId, username);
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
        if (user.getId() == null) {
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

    @Override
    public boolean resetPassword(Integer userId) {
        User u = new User();
        u.setId(userId);
        u.setPassword("123456");
        return userDao.updateByPrimaryKeySelective(u) > 0;
    }

    @Override
    public int modifyPassword(Integer userId, String oldPassword, String newPassword) {
        // 查询用户密码
        User user1 = userDao.selectByPrimaryKey(userId);
        // 比较原始密码
        if (!StringUtils.equals(user1.getPassword(), oldPassword)) {
            return ApplicationConfig.USER_PASSWORD_ERROR;
        }
        User user = new User();
        user.setId(userId);
        user.setPassword(newPassword);
        return userDao.updateByPrimaryKeySelective(user) > 0 ? ApplicationConfig.APPLICATION_OK : ApplicationConfig.APPLICATION_ERROR;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
