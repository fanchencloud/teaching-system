package cn.chen.teachingsystem.service;

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
}
