package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 获取所有的课程列表
     *
     * @return 课程列表
     */
    List<Course> selectAll();

    List<Course> selectByCondition(Integer courseId, String courseName, String college);
}