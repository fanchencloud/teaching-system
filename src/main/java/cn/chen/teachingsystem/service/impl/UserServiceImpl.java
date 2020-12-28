package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.service.UserService;
import cn.chen.teachingsystem.util.MD5Utils;
import cn.chen.teachingsystem.util.RequestContextHolderUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
        // 加密用户密码进行查询
        password = MD5Utils.encryption(password, username);
        User user = userDao.selectByUsernameAndPassword(username, password);
        // 登录成功
        if (user != null && user.getUserType() == type) {
            // 获取 session 对象
            HttpSession session = RequestContextHolderUtil.getSession();
            // 将用户信息存储到session中
            session.setAttribute("user", user);
            // 返回登录成功
            return true;
        } else {
            return false;
        }
    }

    /**
     * 退出登录
     *
     * @return 操作结果
     */
    @Override
    public boolean signOut() {
        // 获取 session 对象
        HttpSession session = RequestContextHolderUtil.getSession();
        // 将用户信息从session中删除
        session.setAttribute("user", null);
        return true;
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
        // 加密密码
        String password = MD5Utils.encryption(user.getPassword(), user.getUsername());
        user.setPassword(password);
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
        // 通过用户id查询用户信息
        User user = userDao.selectByPrimaryKey(userId);
        User u = new User();
        u.setId(userId);
        u.setPassword(MD5Utils.encryption("123456", user.getUsername()));
        return userDao.updateByPrimaryKeySelective(u) > 0;
    }

    @Override
    public int modifyPassword(Integer userId, String oldPassword, String newPassword) {
        // 查询用户密码
        User user1 = userDao.selectByPrimaryKey(userId);
        String old_password = MD5Utils.encryption(oldPassword, user1.getUsername());
        // 比较原始密码
        if (!StringUtils.equals(user1.getPassword(), old_password)) {
            return ApplicationConfig.USER_PASSWORD_ERROR;
        }
        User user = new User();
        user.setId(userId);
        user.setPassword(MD5Utils.encryption(newPassword, user1.getUsername()));
        return userDao.updateByPrimaryKeySelective(user) > 0 ? ApplicationConfig.APPLICATION_OK : ApplicationConfig.APPLICATION_ERROR;
    }

    /**
     * 根据教师编号或者教师姓名查询教师信息
     *
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @return 教师信息列表
     */
    @Override
    public List<User> selectByIdOrName(Integer teacherId, String teacherName) {
        return userDao.selectByIdOrName(teacherId, teacherName);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
