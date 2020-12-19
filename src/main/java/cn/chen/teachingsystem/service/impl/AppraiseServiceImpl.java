package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.mapper.AppraiseDao;
import cn.chen.teachingsystem.model.AppraiseModel;
import cn.chen.teachingsystem.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/18
 * @Time: 23:08
 * @Description:
 */
@Service
public class AppraiseServiceImpl implements AppraiseService {

    @Autowired
    private AppraiseDao appraiseDao;

    @Override
    public List<AppraiseModel> getAppraiseList(Integer id, Integer userId, String leaderName) {
        return appraiseDao.selectByCondition(userId, leaderName, id);
    }

    /**
     * 领导评价一位用户
     *
     * @param userId              被评价的用户id
     * @param leaderId            领导的用户id
     * @param content             评价内容
     * @param appraiseTypeTeacher 评价类别：1-督导，2-教师
     * @return 评价结果
     */
    @Override
    public boolean evaluation(Integer userId, Integer leaderId, String content, int appraiseTypeTeacher) {
        Appraise appraise = new Appraise();
        appraise.setContent(content);
        appraise.setLeaderId(leaderId);
        appraise.setTeacherId(userId);
        appraise.setType(appraiseTypeTeacher);
        return appraiseDao.insertSelective(appraise) > 0;
    }
}
