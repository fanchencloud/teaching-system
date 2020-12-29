package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.model.AppraiseModel;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/18
 * @Time: 23:06
 * @Description:
 */
public interface AppraiseService {

    /**
     * 获取评价列表
     *
     * @param id         评价的唯一id
     * @param userId     督导（教师）id
     * @param leaderName 领导姓名
     * @return
     */
    List<AppraiseModel> getAppraiseList(Integer id, Integer userId, String leaderName);

    /**
     * 领导评价一位用户
     *
     * @param userId              被评价的用户id
     * @param leaderId            领导的用户id
     * @param content             评价内容
     * @param appraiseTypeTeacher 评价类别：1-督导，2-教师
     * @return 评价结果
     */
    boolean evaluation(Integer userId, Integer leaderId, String content, int appraiseTypeTeacher);

    /**
     * 领导评价一位用户
     *
     * @param userId              被评价的用户id
     * @param leaderId            领导的用户id
     * @param content             评价内容
     * @param appraiseTypeTeacher 评价类别：1-督导，2-教师
     * @param level               评优等级
     * @return 评价结果
     */
    boolean evaluation(Integer userId, Integer leaderId, String content, int appraiseTypeTeacher, String level);

    /**
     * 教师自评
     *
     * @param teacherId 教师id
     * @param courseId  课程id
     * @param content   自评内容
     * @return 自评结果
     */
    boolean selfEvaluation(Integer teacherId, Integer courseId, String content);

    /**
     * 获取督导的评价总结
     *
     * @param superviseId 督导编号
     * @return 评价总结
     */
    Appraise getAppraiseSupervisorEvaluationSummary(Integer superviseId);
    /**
     * 查看教师评估总结
     *
     * @param teacherId 教师编号
     * @return 评价总结
     */
    Appraise getAppraiseTeacherEvaluationSummary(Integer teacherId);
}
