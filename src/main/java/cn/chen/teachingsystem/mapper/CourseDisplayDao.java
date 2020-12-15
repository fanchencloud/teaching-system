package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.model.CourseDisplay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 5:55
 * @Description: 课程展示列表持久化层
 */
@Mapper
public interface CourseDisplayDao {

    /**
     * 通过课程编号、课程名、课程上课时间、课程类型、所属学院等条件查询督导选课所需要的课程列表(督导使用)
     *
     * @param courseId   课程编号
     * @param courseName 课程名
     * @param courseTime 课程上课时间
     * @param courseType 课程类型
     * @param college    课程所属学院
     * @return 课程列表
     */
    List<CourseDisplay> getCourseList(Integer courseId, String courseName, String courseTime, String courseType, String college);
}
