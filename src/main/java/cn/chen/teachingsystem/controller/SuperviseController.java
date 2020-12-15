package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Supervision;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.SupervisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/15
 * @Time: 4:39
 * @Description: 督导相关API
 */
@Controller
@Api(tags = "督导相关API")
@RequestMapping(value = "/supervise")
public class SuperviseController {

    /**
     * 督导情况服务对象
     */
    private SupervisionService supervisionService;

    /**
     * 查询督导课程的完成度
     *
     * @param userId 督导id
     * @return 完成情况
     */
    @GetMapping(value = "/getCompletionOfSupervision")
    @ResponseBody
    @ApiOperation("查询督导课程的完成度")
    public JsonResponse getCompletionOfSupervision(Integer userId) {
        Supervision supervision = supervisionService.getCompletion(userId);
        return JsonResponse.ok(supervision);
    }

    @Autowired
    public void setSupervisionService(SupervisionService supervisionService) {
        this.supervisionService = supervisionService;
    }
}
