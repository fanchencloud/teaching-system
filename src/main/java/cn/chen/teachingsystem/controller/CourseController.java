package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.CourseService;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 获取所有的课程列表
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
        List<Course> courseList = courseService.findCourse(courseId,courseName,college);
        return JsonResponse.ok(courseList);
    }


    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
