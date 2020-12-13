package cn.chen.teachingsystem.service;

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

}
