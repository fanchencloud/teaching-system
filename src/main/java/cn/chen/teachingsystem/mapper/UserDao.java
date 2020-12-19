package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    User selectByUsernameAndPassword(String username, String password);

    int updateByPrimaryKeySelective(@Param("user") User user);

    int updateByPrimaryKey(@Param("user") User user);

    List<User> selectByIdOrUsername(Integer userId, String username);
    List<User> selectByIdOrName(@Param("userId") Integer userId, @Param("name") String name);
}