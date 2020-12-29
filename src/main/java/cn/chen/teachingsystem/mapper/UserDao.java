package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chen
 */
@Mapper
public interface UserDao {
    /**
     * 删除一个用户
     *
     * @param id 用户的唯一标识id
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加一个用户到数据库
     *
     * @param user 用户信息
     * @return 添加结果
     */
    int insert(@Param("user") User user);

    /**
     * 添加一个用户信息
     *
     * @param user 用户信息
     * @return 添加结果
     */
    int insertSelective(User user);

    /**
     * 通过用户id查询用户的普通信息
     *
     * @param id 用户id
     * @return 用户基本信息
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 通过用户id查询用户的普通信息
     *
     * @param id 用户id
     * @return 用户基本信息
     */
    User selectByPrimaryKey2(Integer id);

    /**
     * 根据用户名和用户密码查询用户细信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 用户信息
     */
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(@Param("user") User user);

    int updateByPrimaryKey(@Param("user") User user);

    List<User> selectByIdOrUsername(@Param("userId") Integer userId, @Param("username") String username);

    List<User> selectByIdOrName(@Param("userId") Integer userId, @Param("name") String name);
}