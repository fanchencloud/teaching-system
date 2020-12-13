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
}