package cn.chen.teachingsystem.mapper;

import cn.chen.teachingsystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    /**
     * 更新课程信息
     *
     * @param record 课程信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 获取所有的课程列表
     *
     * @return 课程列表
     */
    List<Course> selectAll();

    /**
     * 按条件查询
     *
     * @param courseId
     * @param courseName
     * @param college
     * @return
     */
    List<Course> selectByCondition(@Param("courseId") Integer courseId, @Param("courseName") String courseName, @Param("college") String college);

    /**
     * 增加课程编号为 id 的课程的选课人数
     *
     * @param id 课程编号
     */
    int increaseMember(Integer id);

    /**
     * 减少课程编号为 id 的课程的选课人数
     *
     * @param id 课程编号
     */
    int reduceMember(Integer id);

    /**
     * 查询用户编号为<p>userId</p>、课程号、上课时件等条件的督导选择的课程
     *
     * @param userId     用户编号
     * @param courseName 课程名
     * @param time       上课时间
     * @param finish     完成情况
     * @return 选课列表
     */
    List<Course> getSelectedCourse(
            @Param("userId") Integer userId,
            @Param("courseName") String courseName,
            @Param("courseId") Integer courseId,
            @Param("time") String time,
            @Param("college") String college,
            @Param("finish") Integer finish);

    List<Course> findCourseListByTeacherId(Integer teacherId);

    /**
     * 查询已被督导评价的课程
     *
     * @return 课程列表
     */
    List<Course> selectCourseBeEvaluated();


    /**
     * 根据教师编号查询开设的课程数量
     *
     * @param teacherId 教师id
     * @return 开设课程数量
     */
    Integer getNumberOfCourse(Integer teacherId);

    List<Course> selfEvaluationList(@Param("teacherId") Integer teacherId, @Param("courseId") Integer courseId, @Param("courseName") String courseName);
}