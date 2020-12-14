package cn.chen.teachingsystem.service;

import cn.chen.teachingsystem.entity.Announcement;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 5:38
 * @Description: 公告相关服务
 */
public interface AnnouncementService {
    /**
     * 添加一个公告到系统中
     *
     * @param announcement 公告
     * @return 添加结果
     */
    boolean addAnnouncement(Announcement announcement);

    /**
     * 按照id、标题等条件查询公告列表
     *
     * @param id    id
     * @param title 标题
     * @return 公告列表
     */
    List<Announcement> findAnnouncement(Integer id, String title);

    /**
     * 修改公告
     *
     * @param announcement 公告内容
     * @return 修改结果
     */
    boolean modifyAnnouncement(Announcement announcement);

    /**
     * 删除公告
     *
     * @param id 公告id
     * @return 删除结果
     */
    boolean deleteAnnouncement(Integer id);
}
