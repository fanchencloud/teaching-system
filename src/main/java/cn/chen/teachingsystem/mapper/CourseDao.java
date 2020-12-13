package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}