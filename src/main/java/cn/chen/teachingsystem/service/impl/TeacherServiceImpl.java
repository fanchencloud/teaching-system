package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.QuestionnaireDao;
import cn.chen.teachingsystem.mapper.QuestionnaireListMapper;
import cn.chen.teachingsystem.service.CourseService;
import cn.chen.teachingsystem.service.QuestionnaireService;
import cn.chen.teachingsystem.service.TeacherService;
import cn.chen.teachingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/20
 * @Time: 0:42
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    /**
     * 问卷持久层对象
     */
    private QuestionnaireDao questionnaireDao;

    /**
     * 问卷展示持久层对象
     */
    private QuestionnaireListMapper questionnaireListMapper;

    /**
     * 课程服务对象
     */
    private CourseService courseService;
    /**
     * 用户服务对象
     */
    private UserService userService;

    /**
     * 问卷服务对象
     */
    private QuestionnaireService questionnaireService;

    @Override
    public List<Questionnaire> getAppraiseList(Integer courseId) {
        return questionnaireDao.selectByCourseId(courseId);
    }


    @Autowired
    public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    @Autowired
    public void setQuestionnaireListMapper(QuestionnaireListMapper questionnaireListMapper) {
        this.questionnaireListMapper = questionnaireListMapper;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
}
