package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Elective;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ElectiveDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Elective record);

    int insertSelective(Elective record);

    Elective selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Elective record);

    int updateByPrimaryKey(Elective record);

    int sigIn(@Param("userId") Integer userId, @Param("courseId") Integer courseId);
}