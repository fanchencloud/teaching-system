package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.mapper.SupervisionDao;
import cn.chen.teachingsystem.model.SupervisionModel;
import cn.chen.teachingsystem.service.SupervisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SupervisionModel> getSuperviseTaskProgress(Integer userId, String username) {
        return supervisionDao.getSuperviseTaskProgress(userId, username);
    }

    /**
     * 查询 评价督导 页面的督导列表
     *
     * @param userId   督导编号
     * @param userName 督导名字
     * @return 督导列表
     */
    @Override
    public List<SupervisionModel> getSupervisorList(Integer userId, String userName) {
        return supervisionDao.getSupervisorList(userId, userName);
    }

    @Override
    public boolean insertSupervision(Supervision supervision) {
        return supervisionDao.insert(supervision) > 0;
    }

    @Override
    public Supervision getSupervisor(Integer userId) {
        return supervisionDao.selectByUserId(userId);
    }

    /**
     * 更新督导信息
     *
     * @param s
     * @return
     */
    @Override
    public boolean updateSupervision(Supervision s) {
        return supervisionDao.updateByPrimaryKeySelective(s) > 0;
    }

    @Autowired
    public void setSupervisionDao(SupervisionDao supervisionDao) {
        this.supervisionDao = supervisionDao;
    }
}
