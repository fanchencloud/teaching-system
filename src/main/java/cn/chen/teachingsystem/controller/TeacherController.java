package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.CourseService;
import cn.chen.teachingsystem.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/19
 * @Time: 22:17
 * @Description:
 */
@Controller
@Api(tags = "操作教师的请求")
@RequestMapping(value = "/teacher")
public class TeacherController {

    /**
     * 课程服务对象
     */
    private CourseService courseService;

    /**
     * 教师服务对象
     */
    private TeacherService teacherService;

    /**
     * 获取教工编号为<p>teacherId</p>的教师的课程的评价列表
     * 展示的课程是已经有督导评价完的
     *
     * @param teacherId 教工编号
     * @return 课程列表
     */
    @GetMapping(value = "/getCourseList")
    @ResponseBody
    @ApiOperation("获取教工编号为 teacherId 的教师的课程的评价列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号（id）", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse getCourseList(Integer teacherId) {
        List<Course> courseList = courseService.findCourseListByTeacherId(teacherId);
        return JsonResponse.ok(courseList);
    }

    /**
     * 获取课程编号为 courseId 的课程的评价列表
     * 展示的课程是已经有督导评价完的
     *
     * @param courseId 课程编号
     * @return 评价列表
     */
    @GetMapping(value = "/getAppraiseList")
    @ResponseBody
    @ApiOperation("获取课程编号为 courseId 的课程的评价列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程编号（id）", required = true, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse getAppraiseList(Integer courseId) {
        List<Questionnaire> questionnaireList = teacherService.getAppraiseList(courseId);
        Course course = courseService.selectByPrimaryKey(courseId);
        Map<String, Object> map = new HashMap<>(2);
        map.put("questionnaireList", questionnaireList);
        map.put("adminAppraise", course.getContent());
        return JsonResponse.ok(map);
    }

    /**
     * 教师自评页面获取自己开的课程列表
     *
     * @param teacherId  教师id
     * @param courseId   课程编号
     * @param courseName 课程名
     * @return 课程列表
     */
    @GetMapping(value = "/selfEvaluationList")
    @ResponseBody
    @ApiOperation("教师自评页面获取自己开的课程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号（id）", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseName", value = "课程名", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse selfEvaluationList(
            @RequestParam(value = "teacherId") Integer teacherId,
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName) {
        List<Course> courseList = teacherService.selfEvaluationList(teacherId, courseId, courseName);
        return JsonResponse.ok(courseList);
    }

    /**
     * 教师自评页面获取自己开的课程信息
     *
     * @param teacherId 教师id
     * @param courseId  课程编号
     * @return 课程信息
     */
    @GetMapping(value = "/selfEvaluationPage")
    @ResponseBody
    @ApiOperation("教师自评页面获取自己开的课程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号（id）", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer", dataTypeClass = Integer.class)})
    public JsonResponse selfEvaluationPage(
            @RequestParam(value = "teacherId") Integer teacherId,
            @RequestParam(value = "courseId", required = false) Integer courseId) {
        Map<String, Object> res = teacherService.selfEvaluationPage(teacherId, courseId);
        return JsonResponse.ok(res);
    }

    /**
     * 教师自评页面获取自己开的课程列表
     *
     * @param teacherId 教师id
     * @param courseId  课程编号
     * @param content   评价内容
     * @return 评价结果
     */
    @PostMapping(value = "/selfEvaluation")
    @ResponseBody
    @ApiOperation("教师自评信息提交")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacherId", value = "教师编号（id）", required = true, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "content", value = "评价内容", required = false, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse selfEvaluation(
            @RequestParam(value = "teacherId") Integer teacherId,
            @RequestParam(value = "courseId") Integer courseId,
            @RequestParam(value = "content") String content) {
        if (teacherService.selfEvaluation(teacherId, courseId, content)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("自评失败！");
        }
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
