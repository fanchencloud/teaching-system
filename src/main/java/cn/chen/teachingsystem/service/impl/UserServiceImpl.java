package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.service.SupervisionService;
import cn.chen.teachingsystem.service.UserService;
import cn.chen.teachingsystem.util.MD5Utils;
import cn.chen.teachingsystem.util.RequestContextHolderUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static cn.chen.teachingsystem.conf.ApplicationConfig.*;

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

    /**
     * 督导服务对象
     */
    private SupervisionService supervisionService;

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
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user) throws Exception {
        // 加密密码
        String password = MD5Utils.encryption(user.getPassword(), user.getUsername());
        user.setPassword(password);
        user.setCreateTime(new Date());
        user.setLastEditTime(new Date());
        int insertSelective = userDao.insertSelective(user);
        if (insertSelective <= 0) {
            throw new RuntimeException("添加用户失败");
        }
        // 开始判断用户类型
        if (user.getUserType() == null) {
            throw new RuntimeException("用户类型不能为空");
        }
        // 注册用户为教师督导和专家
        else if (user.getUserType() == USER_TYPE_TEACHER_SUPERVISION || user.getUserType() == USER_TYPE_EXPERT) {
            Supervision supervision = new Supervision();
            supervision.setUserId(user.getId());
            supervision.setAmount(user.getLevel() == SUPERVISE_COURSE_TASK_TYPE_COLLEGE_LEVEL ? SUPERVISE_COURSE_TASK_AMOUNT_COLLEGE_LEVEL : SUPERVISE_COURSE_TASK_AMOUNT_SCHOOL_LEVEL);
            supervision.setFinish(0);
            supervision.setCreateTime(new Date());
            supervision.setLastEditTime(new Date());
            // 督导表添加用户信息
            if (!supervisionService.insertSupervision(supervision)) {
                throw new RuntimeException("督导表添加数据失败");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyUser(User user) {
        if (user.getId() == null) {
            return false;
        }
        user.setUsername(null);
        user.setPassword(null);
        if (userDao.updateByPrimaryKeySelective(user) <= 0) {
            throw new RuntimeException("更新用户信息失败！");
        }
        // 如果修改了用户级别，更新督导表的任务量
        Supervision s = supervisionService.getSupervisor(user.getId());
        if (s != null) {
            // 存在该督导用户
            int amount = user.getLevel() == SUPERVISE_COURSE_TASK_TYPE_COLLEGE_LEVEL ? SUPERVISE_COURSE_TASK_AMOUNT_COLLEGE_LEVEL : SUPERVISE_COURSE_TASK_AMOUNT_SCHOOL_LEVEL;
            Supervision temp = new Supervision();
            temp.setAmount(amount);
            temp.setId(s.getId());
            // 更新数据
            if (!supervisionService.updateSupervision(temp)) {
                throw new RuntimeException("更新督导信息失败！");
            }
        }
        return true;
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
            return USER_PASSWORD_ERROR;
        }
        User user = new User();
        user.setId(userId);
        user.setPassword(MD5Utils.encryption(newPassword, user1.getUsername()));
        return userDao.updateByPrimaryKeySelective(user) > 0 ? APPLICATION_OK : APPLICATION_ERROR;
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

    @Autowired
    public void setSupervisionService(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }
}
