package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.mapper.CourseDao;
import cn.chen.teachingsystem.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 9:06
 * @Description:
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private CourseDao courseDao;

    @Override
    public List<Course> getQuestionnaireCourse(Integer userId, Integer courseId, String college) {
        return courseDao.getSelectedCourse(userId, null, null, null, college, 1);
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
