package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
     * @param record 用户信息
     * @return 添加结果
     */
    int insert(User record);


    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsernameAndPassword(String username, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}