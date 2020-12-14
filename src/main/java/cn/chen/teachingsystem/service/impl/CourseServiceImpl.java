package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.mapper.CourseDao;
import cn.chen.teachingsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    /**
     * 课程数据持久层对象
     */
    private CourseDao courseDao;

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

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
