package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Course;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 4:16
 * @Description:
 */
public interface CourseService {

    /**
     * 添加一门课程
     *
     * @param course 课程
     * @return 添加结果
     */
    boolean addCourse(Course course);

    /**
     * 修改课程信息
     *
     * @param course 课程信息
     * @return 修改结果
     */
    boolean modifyCourse(Course course);

    /**
     * 获取所有的课程列表
     *
     * @return 课程列表
     */
    List<Course> getAllCourse();

    /**
     * 按照课程编号、课程名、学院查询课程列表
     *
     * @param courseId   课程编号
     * @param courseName 课程名
     * @param college    学院
     * @return 课程；列表
     */
    List<Course> findCourse(Integer courseId, String courseName, String college);
}
