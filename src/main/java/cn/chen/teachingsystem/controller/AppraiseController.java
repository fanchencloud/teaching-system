package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.model.AppraiseModel;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.AppraiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/16
 * @Time: 9:37
 * @Description: 领导评价的控制器
 */
@Controller
@Api(tags = "领导评价")
@RequestMapping(value = "/appraise")
public class AppraiseController {

    @Autowired
    private AppraiseService appraiseService;

    public JsonResponse searchAppraise(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "leaderName", required = false) String leaderName,
            @RequestParam(value = "courseName", required = false) String courseName) {
        return null;
    }


    /**
     * 获取领导评价
     *
     * @param id         领导评价id
     * @param userId     督导用户id
     * @param leaderName 领导姓名
     * @return
     */
    @GetMapping(value = "/getAppraiseList")
    @ResponseBody
    @ApiOperation("获取领导评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "督导用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "leaderName", value = "领导姓名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "领导评价id", required = false, dataType = "Integer")
    })
    public JsonResponse getAppraiseList(
            @RequestParam(value = "userId", required = true) Integer userId,
            @RequestParam(value = "leaderName", required = false) String leaderName,
            @RequestParam(value = "id", required = false) Integer id) {
        List<AppraiseModel> appraiseList = appraiseService.getAppraiseList(id, userId, leaderName);
        return JsonResponse.ok(appraiseList);
    }
}
