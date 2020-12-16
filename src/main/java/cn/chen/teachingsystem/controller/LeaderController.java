package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.model.SupervisionModel;
import cn.chen.teachingsystem.service.SupervisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @Date: 2020/12/16
 * @Time: 9:52
 * @Description:
 */
@Controller
@Api(tags = "领导相关API控制器")
@RequestMapping(value = "/leader")
public class LeaderController {

    /**
     * 督导任务服务对象
     */
    private SupervisionService supervisionService;


    /**
     * 查询督导任务进度
     *
     * @param userId   督导id
     * @param username 督导姓名
     * @return 督导任务进度
     */
    @GetMapping(value = "/getSuperviseTaskProgress")
    @ResponseBody
    @ApiOperation("查询督导任务进度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "(督导)用户编号", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "(督导)用户姓名", required = false, dataType = "String")
    })
    public JsonResponse getSuperviseTaskProgress(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "username", required = false) String username) {
        List<SupervisionModel> superviseTaskProgress = supervisionService.getSuperviseTaskProgress(userId, username);
        return JsonResponse.ok(superviseTaskProgress);
    }

    @Autowired
    public void setSupervisionService(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }
}
