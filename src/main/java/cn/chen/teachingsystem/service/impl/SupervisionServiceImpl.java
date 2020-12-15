package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.mapper.SupervisionDao;
import cn.chen.teachingsystem.service.SupervisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 4:45
 * @Description: 督导情况服务接口实现类
 */
@Service
public class SupervisionServiceImpl implements SupervisionService {
    /**
     * 督导情况数据持久层对象
     */
    private SupervisionDao supervisionDao;

    @Override
    public Supervision getCompletion(Integer userId) {
        return supervisionDao.selectByUserId(userId);
    }

    @Autowired
    public void setSupervisionDao(SupervisionDao supervisionDao) {
        this.supervisionDao = supervisionDao;
    }
}
