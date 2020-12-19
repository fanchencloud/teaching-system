package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.User;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/13
 * @Time: 20:08
 * @Description:
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @param type     用户类别
     * @return 登录结果
     */
    boolean login(String username, String password, int type);

    /**
     * 获取用户的基本信息
     *
     * @param userId 用户id
     * @return 用户基本信息
     */
    User getUserInformation(int userId);

    /**
     * 通过用户名或者用户编号查询用户信息
     *
     * @param userId   用户编号
     * @param username 用户名
     * @return 用户信息列表
     */
    List<User> findUserByUseridAndUsername(Integer userId, String username);

    /**
     * 添加用户到数据库
     *
     * @param user 用户信息
     * @return 添加结果
     */
    boolean addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 修改结果
     */
    boolean modifyUser(User user);

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return 删除结果
     */
    boolean delete(Integer userId);

    /**
     * 重置用户密码
     *
     * @param userId 用户编号
     * @return 重置结果
     */
    boolean resetPassword(Integer userId);

    /**
     * 修改用户密码
     *
     * @param userId 用户id
     * @return 修改结果
     */
    int modifyPassword(Integer userId, String oldPassword, String newPassword);

    /**
     * 根据教师编号或者教师姓名查询教师信息
     *
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @return 教师信息列表
     */
    List<User> selectByIdOrName(Integer teacherId, String teacherName);
}
