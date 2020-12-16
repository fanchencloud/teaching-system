package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.model.SupervisionModel;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 4:44
 * @Description: 督导情况服务接口
 */
public interface SupervisionService {
    /**
     * 查询督导完成情况
     *
     * @param userId 督导id
     * @return 完成情况
     */
    Supervision getCompletion(Integer userId);

    /**
     * 查询督导任务进度
     *
     * @param userId   督导id
     * @param username 督导姓名
     * @return 督导任务进度
     */
    List<SupervisionModel> getSuperviseTaskProgress(Integer userId, String username);

}
