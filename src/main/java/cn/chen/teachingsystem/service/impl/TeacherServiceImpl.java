package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.QuestionnaireDao;
import cn.chen.teachingsystem.mapper.QuestionnaireListMapper;
import cn.chen.teachingsystem.service.*;
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
     * 评价服务对象
     */
    private AppraiseService appraiseService;

    /**
     * 问卷服务对象
     */
    private QuestionnaireService questionnaireService;

    @Override
    public List<Questionnaire> getAppraiseList(Integer courseId) {
        return questionnaireDao.selectByCourseId(courseId);
    }

    /**
     * 获取教师自己开设的课程列表
     *
     * @param teacherId  教师id（必须）
     * @param courseId   课程编号
     * @param courseName 课程名
     * @return 可成功列表
     */
    @Override
    public List<Course> selfEvaluationList(Integer teacherId, Integer courseId, String courseName) {
        return courseService.selfEvaluationList(teacherId, courseId, courseName);
    }

    /**
     * 教师自评页面获取自己开的课程信息
     *
     * @param teacherId 教师id
     * @param courseId  课程编号
     * @return 课程信息
     */
    @Override
    public Map<String, Object> selfEvaluationPage(Integer teacherId, Integer courseId) {
        Map<String, Object> map = new HashMap<>(2);
        Course course = courseService.selectByPrimaryKey(courseId);
        map.put("course", course);
        User teacher = userService.getUserInformation(teacherId);
        map.put("teacher", teacher);
        return map;
    }

    /**
     * 教师自评
     *
     * @param teacherId 教师id
     * @param courseId  课程id
     * @param content   自评内容
     * @return 自评结果
     */
    @Override
    public boolean selfEvaluation(Integer teacherId, Integer courseId, String content) {
        return appraiseService.selfEvaluation(teacherId, courseId, content);
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

    @Autowired
    public void setAppraiseService(AppraiseService appraiseService) {
        this.appraiseService = appraiseService;
    }
}
