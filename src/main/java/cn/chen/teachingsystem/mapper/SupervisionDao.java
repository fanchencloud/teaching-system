package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Supervision;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupervisionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Supervision record);

    int insertSelective(Supervision record);

    Supervision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supervision record);

    int updateByPrimaryKey(Supervision record);

    /**
     * 通过督导用户id查询督导完成情况
     * @param userId 督导用户id
     * @return 督导完成情况
     */
    Supervision selectByUserId(Integer userId);
}