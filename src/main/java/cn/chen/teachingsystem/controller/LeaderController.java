package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.model.SupervisionModel;
import cn.chen.teachingsystem.service.LeaderService;
import cn.chen.teachingsystem.service.SupervisionService;
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
 * @Date: 2020/12/16
 * @Time: 9:52
 * @Description:
 */
@Controller
@Api(tags = "领导相关API控制器")
@RequestMapping(value = "/leader")
public class LeaderController {

    /**
     * 督导任务服务对象
     */
    private SupervisionService supervisionService;

    /**
     * 领导服务对象
     */
    private LeaderService leaderService;


    /**
     * 查询督导任务进度
     *
     * @param userId   督导id
     * @param username 督导姓名
     * @return 督导任务进度
     */
    @GetMapping(value = "/getSuperviseTaskProgress")
    @ResponseBody
    @ApiOperation("查询督导任务进度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "(督导)用户姓名", required = false, dataType = "String")
    })
    public JsonResponse getSuperviseTaskProgress(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "username", required = false) String username) {
        List<SupervisionModel> superviseTaskProgress = supervisionService.getSuperviseTaskProgress(userId, username);
        return JsonResponse.ok(superviseTaskProgress);
    }

    /**
     * 查看教师评分
     *
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @param courseId    课程名称
     * @param courseName  课程名称
     * @return 教师评分列表
     */
    @GetMapping("/viewTeacherScoreEvaluation")
    @ResponseBody
    @ApiOperation("查看教师评分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师工号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "teacherName", value = "教师姓名", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseName", value = "课程名称", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse viewTeacherScoreEvaluation(
            @RequestParam(value = "teacherId", required = false) Integer teacherId,
            @RequestParam(value = "teacherName", required = false) String teacherName,
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName) {
        List<Object> res = leaderService.viewTeacherScoreEvaluation(teacherId, teacherName, courseId, courseName);
        return JsonResponse.ok(res);
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
    @GetMapping(value = "/viewQuestionnaireList")
    @ResponseBody
    @ApiOperation("查看问卷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "superviseId", value = "督导工号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "superviseName", value = "督导名字", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "teacherId", value = "教师工号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "teacherName", value = "教师姓名", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseName", value = "课程名称", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse viewQuestionnaireList(
            @RequestParam(value = "superviseId", required = false) Integer superviseId,
            @RequestParam(value = "superviseName", required = false) String superviseName,
            @RequestParam(value = "teacherId", required = false) Integer teacherId,
            @RequestParam(value = "teacherName", required = false) String teacherName,
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName) {
        List<Object> res = leaderService.viewQuestionnaire(superviseId, superviseName, teacherId, teacherName, courseId, courseName);
        return JsonResponse.ok(res);
    }

    /**
     * 查看一份问卷
     *
     * @param id 问卷编号
     * @return 问卷信息
     */
    @GetMapping(value = "/viewQuestionnaire")
    @ResponseBody
    @ApiOperation("查看问卷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "问卷编号", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse viewQuestionnaire(
            @RequestParam(value = "id", required = true) Integer id) {
        Object res = leaderService.viewQuestionnaire(id);
        return JsonResponse.ok(res);
    }

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
     * @param leaderId    领导的用户id
     * @return 信息
     */
    @GetMapping(value = "/evaluationSupervision")
    @ResponseBody
    @ApiOperation("获取评价某一位督导页面的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "superviseId", value = "督导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse evaluationSupervision(
            @RequestParam(value = "superviseId") Integer superviseId,
            @RequestParam(value = "leaderId") Integer leaderId) {
        Object res = leaderService.evaluationSupervision(superviseId, leaderId);
        return JsonResponse.ok(res);
    }

    /**
     * 领导评价一位督导
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id
     * @param content     评价内容
     * @return 评价结果
     */
    @PostMapping(value = "/evaluationSupervision")
    @ResponseBody
    @ApiOperation("领导评价一位督导")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "superviseId", value = "督导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "content", value = "评价内容", required = true, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse evaluationSupervision(
            @RequestParam(value = "superviseId") Integer superviseId,
            @RequestParam(value = "leaderId") Integer leaderId,
            @RequestParam(value = "content") String content) {
        if (leaderService.evaluationSupervision(superviseId, leaderId, content)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("评价失败！");
        }
    }
    /**/

    /**
     * 查询 评价教师 页面的教师列表
     *
     * @param teacherId   教师编号
     * @param teacherName 教师名字
     * @return 督导列表
     */
    @GetMapping(value = "/getTeacherList")
    @ResponseBody
    @ApiOperation("查询 评价教师 页面的教师列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "teacherName", value = "教师名字", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse getTeacherList(
            @RequestParam(value = "teacherId", required = false) Integer teacherId,
            @RequestParam(value = "teacherName", required = false) String teacherName) {
        List<Object> res = leaderService.getTeacherList(teacherId, teacherName);
        return JsonResponse.ok(res);
    }

    /**
     * 获取评价某一位教师页面的信息
     *
     * @param teacherId 教师的用户id
     * @param leaderId  领导的用户id
     * @return 信息
     */
    @GetMapping(value = "/evaluationTeacher")
    @ResponseBody
    @ApiOperation("获取评价某一位教师页面的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse evaluationTeacher(
            @RequestParam(value = "teacherId") Integer teacherId,
            @RequestParam(value = "leaderId") Integer leaderId) {
        Object res = leaderService.evaluationTeacher(teacherId, leaderId);
        return JsonResponse.ok(res);
    }

    /**
     * 领导评价一位教师
     *
     * @param teacherId 教师的用户id
     * @param leaderId  领导的用户id
     * @param content   评价内容
     * @return 评价结果
     */
    @PostMapping(value = "/evaluationTeacher")
    @ResponseBody
    @ApiOperation("领导评价一位教师")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "leaderId", value = "领导的用户id", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "content", value = "评价内容", required = true, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse evaluationTeacher(
            @RequestParam(value = "teacherId") Integer teacherId,
            @RequestParam(value = "leaderId") Integer leaderId,
            @RequestParam(value = "content") String content) {
        if (leaderService.evaluationTeacher(teacherId, leaderId, content)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("评价失败！");
        }
    }

    /**/

    @Autowired
    public void setSupervisionService(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }

    @Autowired
    public void setLeaderService(LeaderService leaderService) {
        this.leaderService = leaderService;
    }
}
