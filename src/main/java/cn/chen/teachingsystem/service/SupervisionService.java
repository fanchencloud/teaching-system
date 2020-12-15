package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Supervision;

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
}
