package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.Appraise;
import cn.chen.teachingsystem.model.JsonResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@ApiOperation("领导评价")
@RequestMapping(value = "/appraise")
public class AppraiseController {

    public JsonResponse searchAppraise(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "leaderName", required = false) String leaderName,
            @RequestParam(value = "courseName", required = false) String courseName
    ) {
        return null;
    }
}
