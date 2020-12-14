package cn.chen.teachingsystem.service.impl;

import cn.chen.teachingsystem.entity.Announcement;
import cn.chen.teachingsystem.mapper.AnnouncementDao;
import cn.chen.teachingsystem.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 5:38
 * @Description: 公告相关服务的实现
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    /**
     * 公告数据持久层对象
     */
    private AnnouncementDao announcementDao;

    @Override
    public boolean addAnnouncement(Announcement announcement) {
        announcement.setFlag(1);
        return announcementDao.insertSelective(announcement) > 0;
    }

    @Override
    public List<Announcement> findAnnouncement(Integer id, String title) {
        return announcementDao.selectByCondition(id, title);
    }

    @Override
    public boolean modifyAnnouncement(Announcement announcement) {
        return announcementDao.updateByPrimaryKeySelective(announcement) > 0;
    }

    @Override
    public boolean deleteAnnouncement(Integer id) {
        announcementDao.deleteByPrimaryKey(id);
        return true;
    }

    @Autowired
    public void setAnnouncementDao(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }
}
