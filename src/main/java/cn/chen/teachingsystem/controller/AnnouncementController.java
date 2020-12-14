package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Announcement;
import cn.chen.teachingsystem.entity.Course;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/14
 * @Time: 5:35
 * @Description:
 */
@Controller
@Api(tags = "公告相关的请求api")
@RequestMapping(value = "/announcement")
public class AnnouncementController {

    /**
     * 公告服务对象
     */
    private AnnouncementService announcementService;

    /**
     * 添加一个公告到系统中
     *
     * @param announcement 公告
     * @return 添加结果
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("添加公告")
    public JsonResponse addAnnouncement(Announcement announcement) {
        if (announcementService.addAnnouncement(announcement)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("添加失败");
        }
    }

    /**
     * 按照id、标题等条件查询公告列表
     *
     * @param id    id
     * @param title 标题
     * @return 公告列表
     */
    @GetMapping(value = "/search")
    @ResponseBody
    @ApiOperation("按条件搜索公告列表")
    public JsonResponse findCourse(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "title", required = false) String title) {

        List<Announcement> announcementList = announcementService.findAnnouncement(id, title);
        return JsonResponse.ok(announcementList);
    }

    /**
     * 修改公告
     *
     * @param announcement 公告内容
     * @return 修改结果
     */
    @PostMapping(value = "/modify")
    @ResponseBody
    @ApiOperation("修改公告")
    public JsonResponse modifyAnnouncement(Announcement announcement) {
        if(announcementService.modifyAnnouncement(announcement)){
            return JsonResponse.ok();
        }else{
            return JsonResponse.errorMsg("修改失败！");
        }
    }

    /**
     * 删除公告
     * @param id 公告id
     * @return 删除结果
     */
    @PostMapping(value = "/del")
    @ResponseBody
    @ApiOperation("删除公告")
    public JsonResponse delete(Integer id){
        if(announcementService.deleteAnnouncement(id)){
            return JsonResponse.ok();
        }else{
            return JsonResponse.errorMsg("删除失败！");
        }
    }

    @Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
}
