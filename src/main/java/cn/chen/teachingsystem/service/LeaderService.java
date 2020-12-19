package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.model.SupervisionModel;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/20
 * @Time: 2:01
 * @Description:
 */
public interface LeaderService {
    /**
     * 查询教师得分评价
     *
     * @param teacherId   教师工号
     * @param teacherName 教师姓名
     * @param courseId    课程编号
     * @param courseName  课程名
     * @return 评价列表
     */
    List<Object> viewTeacherScoreEvaluation(Integer teacherId, String teacherName, Integer courseId, String courseName);

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
    List<Object> viewQuestionnaire(Integer superviseId, String superviseName, Integer teacherId, String teacherName, Integer courseId, String courseName);

    /**
     * 根据问卷编号查询单独一份问卷的信息
     *
     * @param id 问卷编号
     * @return 问卷信息
     */
    Object viewQuestionnaire(Integer id);

    /**
     * 查询 评价督导 页面的督导列表
     *
     * @param userId   督导编号
     * @param userName 督导名字
     * @return 督导列表
     */
    List<SupervisionModel> getSupervisorList(Integer userId, String userName);

    /**
     * 获取评价某一位督导页面的信息
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id
     * @return 信息
     */
    Object evaluationSupervision(Integer superviseId, Integer leaderId);

    /**
     * 领导评价一位督导
     *
     * @param superviseId 督导的用户id
     * @param leaderId    领导的用户id
     * @param content     评价内容
     * @return 评价结果
     */
    boolean evaluationSupervision(Integer superviseId, Integer leaderId, String content);

    /**
     * 查询 评价教师 页面的教师列表
     *
     * @param teacherId   教师编号
     * @param teacherName 教师名字
     * @return 督导列表
     */
    List<Object> getTeacherList(Integer teacherId, String teacherName);

    /**
     * 获取评价某一位教师页面的信息
     *
     * @param teacherId 教师的用户id
     * @param leaderId    领导的用户id
     * @return 信息
     */
    Object evaluationTeacher(Integer teacherId, Integer leaderId);

    /**
     * 领导评价一位教师
     *
     * @param teacherId 教师的用户id
     * @param leaderId  领导的用户id
     * @param content   评价内容
     * @return 评价结果
     */
    boolean evaluationTeacher(Integer teacherId, Integer leaderId, String content);
}
