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
}
