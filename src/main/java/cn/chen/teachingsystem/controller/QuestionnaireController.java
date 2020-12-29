package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.QuestionnaireListMapper;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.model.QuestionnaireList;
import cn.chen.teachingsystem.service.CourseService;
import cn.chen.teachingsystem.service.QuestionnaireService;
import cn.chen.teachingsystem.service.UserService;
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
 * @Date: 2020/12/14
 * @Time: 7:07
 * @Description:
 */
@Controller
@RequestMapping(value = "/questionnaire")
@Api(tags = "问卷相关API")
public class QuestionnaireController {

    private QuestionnaireListMapper questionnaireListMapper;
    private UserService userService;
    private CourseService courseService;
    private QuestionnaireService questionnaireService;



    /**
     * 获取用户id为<P>userId</P>的督导员可以填写问卷的课程列表
     *
     * @param userId   督导员的用户id
     * @param courseId 课程编号
     * @param college  课程所属学院
     * @return 课程列表
     */
    @GetMapping(value = "/getQuestionnaireCourse")
    @ResponseBody
    @ApiOperation("获取用户id为 userId 的督导员可以填写问卷的课程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号（必填）", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号", required = false, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "college", value = "课程所属学院", required = false, dataType = "String", dataTypeClass = String.class)
    })
    public JsonResponse getQuestionnaireCourse(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "college", required = false) String college) {
        List<Course> courseList = questionnaireService.getQuestionnaireCourse(userId, courseId, college);
        return JsonResponse.ok(courseList);
    }

    /**
     * 获取填写一份问卷的时候需要显示的信息
     *
     * @param userId   督导的用户id
     * @param courseId 课程的课程id
     * @return 信息数据
     */
    @GetMapping(value = "/fillInTheQuestionnaire")
    @ResponseBody
    @ApiOperation("获取填写一份问卷的时候需要显示的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号（必填）", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "courseId", value = "课程编号（必填）", required = true, dataType = "String", dataTypeClass = String.class)
    })
    public JsonResponse fillInTheQuestionnaire(Integer userId, Integer courseId) {
        // 1- 查询督导信息
        User supervise = userService.getUserInformation(userId);
        // 2- 查询课程信息
        List<Course> courseList = courseService.findCourse(courseId, null, null);
        Course course = courseList.get(0);
        // 3- 查询教师信息
        User teacher = userService.getUserInformation(course.getTeacherId());
        Map<String, Object> map = new HashMap<>(3);
        map.put("supervise", supervise);
        map.put("course", course);
        map.put("teacher", teacher);
        return JsonResponse.ok(map);
    }

    /**
     * 填写一份问卷
     *
     * @param questionnaire 问卷信息
     * @return 填写结果
     */
    @PostMapping(value = "/fillInTheQuestionnaire")
    @ResponseBody
    @ApiOperation("填写一份问卷")
    public JsonResponse fillInTheQuestionnaire(Questionnaire questionnaire) {
        if (questionnaireService.fillInTheQuestionnaire(questionnaire)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("填写失败！");
        }
    }

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
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
    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
}
