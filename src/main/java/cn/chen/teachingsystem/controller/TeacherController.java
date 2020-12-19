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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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





    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
