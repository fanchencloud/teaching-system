package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.CourseDisplay;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.CourseService;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 4:04
 * @Description:
 */
@Controller
@Api(tags = "关于课程的操作")
@RequestMapping(value = "/course")
public class CourseController {
    /**
     * 课程服务对象
     */
    private CourseService courseService;

    /**
     * 添加一个课程到系统中
     *
     * @param course 课程信息
     * @return 添加结果
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("添加课程")
    public JsonResponse addCourse(Course course) {
        if (courseService.addCourse(course)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("添加失败");
        }
    }

//    /**
//     * 从系统中删除一个课程
//     *
//     * @param course 课程信息
//     * @return 添加结果
//     */
//    @PostMapping(value = "/add")
//    @ResponseBody
//    @ApiOperation("添加课程")
//    public JsonResponse addCourse(Course course) {
//        if (courseService.addCourse(course)) {
//            return JsonResponse.ok();
//        } else {
//            return JsonResponse.errorMsg("添加失败");
//        }
//    }

    /**
     * 修改一个课程到系统中
     *
     * @param course 课程信息
     * @return 修改结果
     */
    @PostMapping(value = "/modify")
    @ResponseBody
    @ApiOperation("修改课程")
    public JsonResponse modifyCourse(Course course) {
        if (courseService.modifyCourse(course)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("添加失败");
        }
    }

    /**
     * 获取所有的课程列表（管理员页面展示）
     *
     * @return 课程列表
     */
    @GetMapping(value = "/list")
    @ResponseBody
    @ApiOperation("获取所有课程列表")
    public JsonResponse getAllCourse() {
        List<Course> courseList = courseService.getAllCourse();
        return JsonResponse.ok(courseList);
    }

    /**
     * 按照课程编号、课程名、学院查询课程列表
     *
     * @param courseId   课程编号
     * @param courseName 课程名
     * @param college    学院
     * @return 课程；列表
     */
    @GetMapping(value = "/search")
    @ResponseBody
    @ApiOperation("按条件搜索课程列表")
    public JsonResponse findCourse(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "college", required = false) String college) {
//        if(courseId == null && StringUtils.isEmpty(courseName) && StringUtils.isEmpty(college)){
//            return JsonResponse.errorMsg("查询信息不能全空！");
//        }
        List<Course> courseList = courseService.findCourse(courseId, courseName, college);
        return JsonResponse.ok(courseList);
    }

    /**
     * 通过课程编号、课程名、课程上课时间、课程类型、所属学院等条件查询督导选课所需要的课程列表(督导使用)
     *
     * @param courseId   课程编号
     * @param courseName 课程名
     * @param courseTime 课程上课时间
     * @param courseType 课程类型
     * @param college    课程所属学院
     * @return 课程列表
     */
    @GetMapping(value = "/getCourseList")
    @ResponseBody
    @ApiOperation("通过课程编号、课程名、课程上课时间、课程类型、所属学院等条件查询督导选课所需要的课程列表(督导使用)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "courseName", value = "课程名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "courseTime", value = "课程上课时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "courseType", value = "课程类型", required = false, dataType = "String"),
            @ApiImplicitParam(name = "college", value = "课程所属学院", required = false, dataType = "String")
    })
    public JsonResponse getCourseList(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "courseTime", required = false) String courseTime,
            @RequestParam(value = "courseType", required = false) String courseType,
            @RequestParam(value = "college", required = false) String college) {
        List<CourseDisplay> courseDisplayList = courseService.getCourseList(courseId, courseName, courseTime, courseType, college);
        return JsonResponse.ok(courseDisplayList);
    }

    /**
     * 选择课程
     *
     * @param courseId 课程编号
     * @param userId   选课用户id
     * @return 选课结果
     */
    @PostMapping(value = "/electiveCourse")
    @ResponseBody
    @ApiOperation("选择课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "课程编号（必填）", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userId", value = "选课用户id（必填）", required = true, dataType = "Integer")
    })
    public JsonResponse electiveCourse(Integer courseId, Integer userId) {
        if (courseService.electiveCourse(courseId, userId)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("选课失败！");
        }
    }

    /**
     * 查询用户编号为<p>userId</p>、课程号、上课时件等条件的督导选择的课程
     *
     * @param userId     用户编号
     * @param courseName 课程名
     * @param time       上课时间
     * @return 选课列表
     */
    @GetMapping(value = "/elected")
    @ResponseBody
    @ApiOperation("已选课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号（必填）", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "courseName", value = "课程名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "time", value = "上课时间", required = false, dataType = "String")
    })
    public JsonResponse getListeningCourse(@RequestParam(value = "userId") Integer userId,
                                           @RequestParam(value = "courseName", required = false) String courseName,
                                           @RequestParam(value = "time", required = false) String time) {
        return JsonResponse.ok(courseService.getSelectedCourse(userId, courseName, time));
    }


    /**
     * 督导对已选课程进行签到
     *
     * @param userId   督导ID
     * @param courseId 课程id
     * @return 签到结果
     */
    @PostMapping(value = "/signIn")
    @ResponseBody
    @ApiOperation("督导对已选课程进行签到")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号（必填）", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "courseId", value = "课程编号（必填）", required = true, dataType = "Integer")
    })
    public JsonResponse signIn(Integer userId, Integer courseId) {
        if (courseService.signIn(userId, courseId)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("签到失败！");
        }
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
