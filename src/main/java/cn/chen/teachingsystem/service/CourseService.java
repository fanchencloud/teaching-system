package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.model.CourseDisplay;

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

    /**
     * 督导选课
     *
     * @param courseId 课程编号
     * @param userId   督导的编号
     * @return 选课结果
     */
    boolean electiveCourse(Integer courseId, Integer userId);

    /**
     * 查询用户编号为<p>userId</p>、课程号、上课时件等条件的督导选择的课程
     *
     * @param userId     用户编号
     * @param courseName 课程名
     * @param time       上课时间
     * @return 选课列表
     */
    public List<Course> getSelectedCourse(Integer userId, String courseName, String time);

    /**
     * 督导对已选课程进行签到
     *
     * @param userId   督导ID
     * @param courseId 课程id
     * @return 签到结果
     */
    boolean signIn(Integer userId, Integer courseId) ;
}
