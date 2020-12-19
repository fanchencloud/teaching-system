package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Elective;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.CourseDao;
import cn.chen.teachingsystem.mapper.CourseDisplayDao;
import cn.chen.teachingsystem.mapper.ElectiveDao;
import cn.chen.teachingsystem.mapper.UserDao;
import cn.chen.teachingsystem.model.CourseDisplay;
import cn.chen.teachingsystem.service.CourseService;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 4:17
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 课程数据持久层对象
     */
    private CourseDao courseDao;

    /**
     * 课程展示列表数据持久化对象
     */
    private CourseDisplayDao courseDisplayDao;

    /**
     * 选课数据持久层对象
     */
    private ElectiveDao electiveDao;

    /**
     * 用户数据持久层对象
     */
    private UserDao userDao;

    @Override
    public boolean addCourse(Course course) {
        return courseDao.insertSelective(course) > 0;
    }

    @Override
    public boolean modifyCourse(Course course) {
        return courseDao.updateByPrimaryKeySelective(course) > 0;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.selectAll();
    }

    @Override
    public List<Course> findCourse(Integer courseId, String courseName, String college) {
        return courseDao.selectByCondition(courseId, courseName, college);
    }

    @Override
    public List<CourseDisplay> getCourseList(Integer courseId, String courseName, String courseTime, String courseType, String college) {
        return courseDisplayDao.getCourseList(courseId, courseName, courseTime, courseType, college);
    }

    /**
     * 发生异常就回滚数据
     */
    @Override
    @Transactional
    public boolean electiveCourse(Integer courseId, Integer userId) {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setName("updateMessage");
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        // 1、课程表上的选课人数加一
        // 1.1 查询课程表数据
        Course course = courseDao.selectByPrimaryKey(courseId);
        if (course.getMember() >= course.getCapacity()) {
            // 选课人数已满，超过课程容量
            return false;
        }
        // 1.2 修改选课人数
        int record = courseDao.increaseMember(courseId);
        if (record <= 0) {
            throw new RuntimeException("修改选课人数失败！");
        }
        // 2、选课表上的数据记录进行添加
        Elective elective = new Elective();
        elective.setUserId(userId);
        elective.setCourseId(courseId);
        elective.setFinish(0);
        int i = electiveDao.insertSelective(elective);
        if (i <= 0) {
            throw new RuntimeException("添加选课记录失败！");
        }
        return true;
    }

    /**
     * 查询用户编号为<p>userId</p>、课程号、上课时件等条件的督导选择的课程
     *
     * @param userId     用户编号
     * @param courseName 课程名
     * @param time       上课时间
     * @return 选课列表
     */
    public List<CourseDisplay> getSelectedCourse(Integer userId, String courseName, String time) {
        List<Course> selectedCourse = courseDao.getSelectedCourse(userId, courseName, null, time, null, null);
        List<CourseDisplay> courseDisplayList = new ArrayList<>(selectedCourse.size());
        for (Course course : selectedCourse) {
            CourseDisplay temp = new CourseDisplay();
            temp.setCourse(course);
            User user = userDao.selectByPrimaryKey2(course.getTeacherId());
            temp.setUser(user);
            courseDisplayList.add(temp);
        }
        return courseDisplayList;
    }

    @Override
    public boolean signIn(Integer userId, Integer courseId) {
        return electiveDao.sigIn(userId, courseId) > 0;
    }

    @Override
    public List<Course> findCourseListByTeacherId(Integer teacherId) {
        return courseDao.findCourseListByTeacherId(teacherId);
    }

    @Override
    public Course selectByPrimaryKey(Integer courseId) {
        return courseDao.selectByPrimaryKey(courseId);
    }

    @Override
    public List<Course> selectCourseBeEvaluated() {
        return courseDao.selectCourseBeEvaluated();
    }

    /**
     * 根据教师编号查询开设的课程数量
     *
     * @param teacherId 教师id
     * @return 开设课程数量
     */
    @Override
    public Integer getNumberOfCourse(Integer teacherId) {
        return courseDao.getNumberOfCourse(teacherId);
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setCourseDisplayDao(CourseDisplayDao courseDisplayDao) {
        this.courseDisplayDao = courseDisplayDao;
    }

    @Autowired
    public void setElectiveDao(ElectiveDao electiveDao) {
        this.electiveDao = electiveDao;
    }

    @Autowired
    public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
