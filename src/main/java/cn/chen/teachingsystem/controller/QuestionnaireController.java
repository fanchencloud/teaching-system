package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.mapper.QuestionnaireListMapper;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.model.QuestionnaireList;
import cn.chen.teachingsystem.service.CourseService;
import cn.chen.teachingsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
 * @Time: 7:07
 * @Description:
 */
@Controller
@RequestMapping(value = "/questionnaire")
@Api(tags = "问卷相关API")
public class QuestionnaireController {

    private QuestionnaireListMapper questionnaireListMapper;
    private UserService service;
    private CourseService courseService;

    @GetMapping(value = "/search")
    @ResponseBody
    @ApiOperation("")
    public JsonResponse getQuestionnaireList(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "courseName", required = false) String courseName,
            @RequestParam(value = "teacherId", required = false) Integer teacherId,
            @RequestParam(value = "teacherName", required = false) String teacherName) {
        List<QuestionnaireList> questionnaireLists = questionnaireListMapper.selectByCondition(courseId, courseName, teacherId, teacherName, null);
        for (int i = 0; i < questionnaireLists.size(); i++) {
            QuestionnaireList questionnaireList = questionnaireLists.get(i);
            User userInformation = service.getUserInformation(questionnaireList.getQuestionnaire().getUserId());
            questionnaireList.setAppraiser(userInformation.getName());
            questionnaireLists.set(i, questionnaireList);
        }
        return JsonResponse.ok(questionnaireLists);
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
    public JsonResponse fillInTheEvaluationByAdmin(Integer courseId, String appraise) {
        Course course = new Course();
        course.setId(courseId);
        course.setContent(appraise);
        if (courseService.modifyCourse(course)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("评价失败");
        }
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @Autowired
    public void setQuestionnaireListMapper(QuestionnaireListMapper questionnaireListMapper) {
        this.questionnaireListMapper = questionnaireListMapper;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
