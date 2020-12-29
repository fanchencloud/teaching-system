package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;

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
public interface TeacherService {

    List<Questionnaire> getAppraiseList(Integer courseId);

    /**
     * 获取教师自己开设的课程列表
     *
     * @param teacherId  教师id（必须）
     * @param courseId   课程编号
     * @param courseName 课程名
     * @return 可成功列表
     */
    List<Course> selfEvaluationList(Integer teacherId, Integer courseId, String courseName);


    /**
     * 教师自评页面获取自己开的课程信息
     *
     * @param teacherId 教师id
     * @param courseId  课程编号
     * @return 课程信息
     */
    Map<String, Object> selfEvaluationPage(Integer teacherId, Integer courseId);

    /**
     * 教师自评
     *
     * @param teacherId 教师id
     * @param courseId  课程id
     * @param content   自评内容
     * @return 自评结果
     */
    boolean selfEvaluation(Integer teacherId, Integer courseId, String content);
}
