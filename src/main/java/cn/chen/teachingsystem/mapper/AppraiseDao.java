package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Appraise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppraiseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}