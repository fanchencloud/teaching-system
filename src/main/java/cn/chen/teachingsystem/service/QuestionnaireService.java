package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.entity.Questionnaire;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 9:06
 * @Description: 问卷方面的服务接口
 */
public interface QuestionnaireService {

    /**
     * 获取用户id为<P>userId</P>的督导员可以填写问卷的课程列表
     *
     * @param userId   督导员的用户id
     * @param courseId 课程编号
     * @param college  课程所属学院
     * @return 课程列表
     */
    List<Course> getQuestionnaireCourse(Integer userId,Integer courseId,String college);

    boolean fillInTheQuestionnaire(Questionnaire questionnaire);
}
