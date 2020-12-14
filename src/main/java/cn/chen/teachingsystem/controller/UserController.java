package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.UserService;
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
 * @Time: 1:48
 * @Description:
 */
@Controller
@Api(tags = "操作用户的请求")
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 用户服务对象
     */
    private UserService userService;

    /**
     * 添加一个用户到系统中
     *
     * @param user 用户信息
     * @return 添加结果
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("添加用户")
    public JsonResponse addUser(User user) {
        boolean flag = userService.addUser(user);
        if (flag) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("添加失败");
        }
    }

    /**
     * 修改一个用户信息
     *
     * @param user 用户信息
     * @return 修改结果
     */
    @PostMapping(value = "/modify")
    @ResponseBody
    @ApiOperation("修改用户信息")
    public JsonResponse modifyUser(User user) {
        if (user == null || user.getId() == null) {
            return JsonResponse.errorMsg("缺少必要信息");
        }
        if (userService.modifyUser(user)) {
            return JsonResponse.ok("修改成功！");
        } else {
            return JsonResponse.errorMsg("修改失败");
        }
    }

    /**
     * 删除一个用户
     *
     * @param userId 用户id
     * @return 删除结果
     */
    @PostMapping(value = "/del")
    @ResponseBody
    @ApiOperation("删除用户")
    public JsonResponse deleteUser(Integer userId) {
        if (userService.delete(userId)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("删除失败");
        }
    }

    /**
     * 请求获取用户的基本信息
     *
     * @param userId 用户id
     * @return 用户基本信息
     */
    @GetMapping("/userInfo")
    @ResponseBody
    @ApiOperation("请求获取用户的基本信息")
    public JsonResponse getUserInfo(int userId) {
        User user = userService.getUserInformation(userId);
        return JsonResponse.ok(user);
    }

    /**
     * 通过用户名或者用户编号查询用户信息
     *
     * @param userId   用户编号
     * @param username 用户名
     * @return 用户信息
     */
    @PostMapping("/search")
    @ResponseBody
    @ApiOperation("请求查询用户的基本信息")
    public JsonResponse searchUser(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "username", required = false) String username) {
        if (userId == null && username == null) {
            return JsonResponse.errorMsg("查询关键字不能都为空");
        }
        List<User> userList = userService.findUserByUseridAndUsername(userId, username);
        return JsonResponse.ok(userList);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
