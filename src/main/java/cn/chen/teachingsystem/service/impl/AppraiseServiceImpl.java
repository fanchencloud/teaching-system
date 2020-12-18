package cn.chen.teachingsystem.service.impl;

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
}
