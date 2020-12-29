package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.SupervisionModel;
import cn.chen.teachingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/20
 * @Time: 2:01
 * @Description:
 */
@Service
public class LeaderServiceImpl implements LeaderService {
    /**
     * 课程服务对象
     */
    private CourseService courseService;

    /**
     * 用户服务对象
     */
    private UserService userService;

    /**
     * 督导服务对象
     */
    private SupervisionService supervisionService;

    /**
     * 问卷服务对象
     */
    private QuestionnaireService questionnaireService;

    /**
     * 领导评价服务对象
     */
    private AppraiseService appraiseService;

    /**
     * 查询教师得分评价
     *
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @param courseId    课程编号
     * @param courseName  课程名
     * @return 评价列表
     */
    @Override
    public List<Object> viewTeacherScoreEvaluation(Integer teacherId, String teacherName, Integer courseId, String courseName) {
        // 1- 查询所有已被评价的课程
        List<Course> courseList = courseService.selectCourseBeEvaluated();
        List<Object> res = new ArrayList<>(courseList.size());
        courseList.forEach(t -> {
            Map<String, Object> map = new HashMap<>(8);
            // 课程信息
            map.put("courseId", t.getId());
            map.put("courseName", t.getCourseName());
            map.put("college", t.getCollege());
            // 用户信息
            User user = userService.getUserInformation(t.getTeacherId());
            map.put("teacherId", user.getId());
            map.put("teacherName", user.getName());
            // 评价信息
            List<Questionnaire> questionnaires = questionnaireService.getQuestionnairesByCourseId(t.getId());
            map.put("number", questionnaires.size());
            int total = questionnaires.stream().mapToInt(Questionnaire::getTotal).sum();
            double average = total / (questionnaires.size() * 1.0);
            map.put("total", total);
            map.put("average", average);
            res.add(map);
        });
        return res;
    }

    /**
     * 查看问卷
     *
     * @param superviseId   督导编号
     * @param superviseName 督导姓名
     * @param teacherId     教师工号
     * @param teacherName   教师姓名
     * @param courseId      课程名称
     * @param courseName    课程名称
     * @return 问卷列表
     */
    @Override
    public List<Object> viewQuestionnaire(Integer superviseId, String superviseName, Integer teacherId, String teacherName, Integer courseId, String courseName) {
        // 1- 获取问卷列表
        List<Questionnaire> questionnaireList = questionnaireService.getAllQuestionnaireList();
        List<Object> res = new LinkedList<>();
        questionnaireList.forEach(questionnaire -> {
            Map<String, Object> map = new HashMap<>(3);
            map.put("questionnaire", questionnaire);
            // 查询评价人的信息
            User supervise = userService.getUserInformation(questionnaire.getUserId());
            map.put("supervise", supervise);
            // 查询教师信息
            User teacher = userService.getUserInformation(questionnaire.getTeacherId());
            map.put("teacher", teacher);
            res.add(map);
        });
        return res;
    }

    @Override
    public Object viewQuestionnaire(Integer id) {
        Map<String, Object> map = new HashMap<>(3);
        Questionnaire questionnaire = questionnaireService.getQuestionnairesById(id);
        map.put("questionnaire", questionnaire);
        // 查询评价人的信息
        User supervise = userService.getUserInformation(questionnaire.getUserId());
        map.put("supervise", supervise);
        // 查询教师信息
        User teacher = userService.getUserInformation(questionnaire.getTeacherId());
        map.put("teacher", teacher);
        return map;
    }

    /**
     * 查询 评价督导 页面的督导列表
     *
     * @param userId   督导编号
     * @param userName 督导名字
     * @return 督导列表
     */
    @Override
    public List<SupervisionModel> getSupervisorList(Integer userId, String userName) {
        return supervisionService.getSupervisorList(userId, userName);
    }

    /**
     * 获取评价某一位督导页面的信息
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id
     * @return 信息
     */
    @Override
    public Object evaluationSupervision(Integer superviseId, Integer leaderId) {
        Map<String, Object> res = new HashMap<>(2);
        // 督导信息
        User supervise = userService.getUserInformation(superviseId);
        User leader = userService.getUserInformation(leaderId);
        res.put("supervise", supervise);
        res.put("leader", leader);
        return res;
    }

    /**
     * 领导评价一位督导
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id
     * @param content     评价内容
     * @param level       评优等级
     * @return 评价结果
     */
    @Override
    public boolean evaluationSupervision(Integer superviseId, Integer leaderId, String content, String level) {
        return appraiseService.evaluation(superviseId, leaderId, content, ApplicationConfig.APPRAISE_TYPE_SUPERVISE, level);
    }

    @Override
    public List<Object> getTeacherList(Integer teacherId, String teacherName) {
        List<User> userList = userService.selectByIdOrName(teacherId, teacherName);
        List<Object> res = new LinkedList<>();

        userList.forEach(user -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("user", user);
            // 根据教师信息查询教师开设的课程
            int num = courseService.getNumberOfCourse(user.getId());
            map.put("num", num);
            res.add(map);
        });
        return res;
    }

    /**
     * 获取评价某一位教师页面的信息
     *
     * @param teacherId 教师的用户id
     * @param leaderId  领导的用户id
     * @return 信息
     */
    @Override
    public Object evaluationTeacher(Integer teacherId, Integer leaderId) {
        Map<String, Object> res = new HashMap<>(2);
        // 教师信息
        User supervise = userService.getUserInformation(teacherId);
        // 领导信息
        User leader = userService.getUserInformation(leaderId);
        res.put("teacher", supervise);
        res.put("leader", leader);
        return res;
    }

    /**
     * 领导评价一位教师
     *
     * @param teacherId 教师的用户id
     * @param leaderId  领导的用户id
     * @param content   评价内容
     * @return 评价结果
     */
    @Override
    public boolean evaluationTeacher(Integer teacherId, Integer leaderId, String content) {
        return appraiseService.evaluation(teacherId, leaderId, content, ApplicationConfig.APPRAISE_TYPE_TEACHER);
    }

    @Override
    public Object viewSupervisorEvaluation(Integer superviseId) {
        Map<String, Object> map = new HashMap<>(3);
        // 评价信息
        Appraise appraise = appraiseService.getAppraiseSupervisorEvaluationSummary(superviseId);
        map.put("appraise", appraise);
        // 督导信息
        User supervise = userService.getUserInformation(superviseId);
        map.put("supervise", supervise);
        // 管理员信息
        User admin = userService.getUserInformation(appraise.getLeaderId());
        map.put("admin", admin);
        return map;
    }

    /**
     * 查看教师评估总结
     *
     * @param teacherId 教师编号
     * @return 评价总结
     */
    @Override
    public Object viewTeacherEvaluationSummary(Integer teacherId) {
        Map<String, Object> map = new HashMap<>(3);
        // 评价信息
        Appraise appraise = appraiseService.getAppraiseTeacherEvaluationSummary(teacherId);
        map.put("appraise", appraise);
        // 教师信息
        User teacher = userService.getUserInformation(teacherId);
        map.put("teacher", teacher);
        // 管理员信息
        User admin = userService.getUserInformation(appraise.getLeaderId());
        map.put("admin", admin);
        return map;
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
    public void setSupervisionService(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }

    @Autowired
    public void setAppraiseService(AppraiseService appraiseService) {
        this.appraiseService = appraiseService;
    }
}
