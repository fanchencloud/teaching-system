package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.conf.ApplicationConfig;
import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.QuestionnaireListMapper;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.model.QuestionnaireList;
import cn.chen.teachingsystem.model.SupervisionModel;
import cn.chen.teachingsystem.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/28
 * @Time: 20:39
 * @Description:
 */
@Controller
@Api(tags = "关于管理员的操作")
@RequestMapping(value = "/admin")
public class AdminController {

    /**
     * 领导服务对象
     */
    private LeaderService leaderService;

    private QuestionnaireListMapper questionnaireListMapper;
    private UserService userService;
    private CourseService courseService;
    private QuestionnaireService questionnaireService;
    private AdminService adminService;


    /**
     * 查询 评价督导 页面的督导列表
     *
     * @param userId   督导编号
     * @param userName 督导名字
     * @return 督导列表
     */
    @GetMapping(value = "/getSupervisorList")
    @ResponseBody
    @ApiOperation("查询 评价督导 页面的督导列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "督导用户编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "userName", value = "督导用户姓名", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse getSupervisorList(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "userName", required = false) String userName) {
        List<SupervisionModel> res = leaderService.getSupervisorList(userId, userName);
        return JsonResponse.ok(res);
    }

    /**
     * 获取评价某一位督导页面的信息
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id（管理员）
     * @return 信息
     */
    @GetMapping(value = "/evaluationSupervision")
    @ResponseBody
    @ApiOperation("获取评价某一位督导页面的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "superviseId", value = "督导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id（管理员）", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse evaluationSupervision(
            @RequestParam(value = "superviseId") Integer superviseId,
            @RequestParam(value = "leaderId") Integer leaderId) {
        Object res = leaderService.evaluationSupervision(superviseId, leaderId);
        return JsonResponse.ok(res);
    }

    /**
     * 评价一位督导
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id（管理员）
     * @param content     评价内容
     * @param level       评优等级
     * @return 评价结果
     */
    @PostMapping(value = "/evaluationSupervision")
    @ResponseBody
    @ApiOperation("管理员评价一位督导")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "superviseId", value = "督导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id（管理员）", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "content", value = "评价内容", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "level", value = "评优等级", required = true, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse evaluationSupervision(
            @RequestParam(value = "superviseId") Integer superviseId,
            @RequestParam(value = "leaderId") Integer leaderId,
            @RequestParam(value = "level") String level,
            @RequestParam(value = "content") String content) {
        if (adminService.evaluationSupervision(superviseId, leaderId, content, level)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("评价失败！");
        }
    }

    /**
     * 管理员问卷管理页面
     *
     * @param courseId    课堂号
     * @param courseName  课堂名
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @return 问卷列表
     */
    @GetMapping(value = "/search")
    @ResponseBody
    @ApiOperation("获取问卷列表展示-管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "courseName", value = "课程名", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "teacherId", value = "教师工号", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "teacherName", value = "教师姓名", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse getQuestionnaireList(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "teacherId", required = false) Integer teacherId,
            @RequestParam(value = "teacherName", required = false) String teacherName) {
        List<QuestionnaireList> questionnaireLists = questionnaireListMapper.selectByCondition(courseId, courseName, teacherId, teacherName, null);
        for (int i = 0; i < questionnaireLists.size(); i++) {
            QuestionnaireList questionnaireList = questionnaireLists.get(i);
            User userInformation = userService.getUserInformation(questionnaireList.getQuestionnaire().getUserId());
            questionnaireList.setAppraiser(userInformation.getName());
            questionnaireLists.set(i, questionnaireList);
        }
        return JsonResponse.ok(questionnaireLists);
    }


    /**
     * 总结评价页面显示的信息
     *
     * @param teacherId 教师编号
     * @param courseId  课程编号
     * @return 信息
     */
    @GetMapping(value = "/summaryEvaluation")
    @ResponseBody
    @ApiOperation("总结评价页面显示的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse summaryEvaluation(Integer teacherId, Integer courseId) {
        Object res = adminService.summaryEvaluation(teacherId, courseId);
        return JsonResponse.ok(res);
    }

    /**
     * 管理员填写评价
     *
     * @param courseId 评价课程编号
     * @param appraise 评价内容
     * @return 评价结果
     */
    @PostMapping(value = "/fillEvalAdmin")
    @ResponseBody
    @ApiOperation("管理员填写评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "管理员编号", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "teacherId", value = "教师编号", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "level", value = "评优等级", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "appraise", value = "评价内容", required = true, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse fillInTheEvaluationByAdmin(Integer userId, Integer courseId, Integer teacherId, String level, String appraise) {
        Appraise a = new Appraise();
        a.setTeacherId(teacherId);
        a.setLeaderId(userId);
        a.setCourseId(courseId);
        a.setLevel(level);
        a.setContent(appraise);
        a.setType(ApplicationConfig.APPRAISE_TYPE_TEACHER_SUMMARY);
        if (adminService.fillInTheEvaluationByAdmin(a)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("评价失败");
        }
    }


    @Autowired
    public void setLeaderService(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @Autowired
    public void setQuestionnaireListMapper(QuestionnaireListMapper questionnaireListMapper) {
        this.questionnaireListMapper = questionnaireListMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
