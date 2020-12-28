package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.entity.User;
import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.chen.teachingsystem.conf.ApplicationConfig.APPLICATION_OK;
import static cn.chen.teachingsystem.conf.ApplicationConfig.USER_PASSWORD_ERROR;

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
     * 管理员重置用户密码
     *
     * @param userId 用户id
     * @return 重置结果
     */
    @GetMapping(value = "/resetPassword")
    @ResponseBody
    @ApiOperation("管理员重置用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "String", dataTypeClass = String.class)})
    public JsonResponse resetPasswordByAdmin(Integer userId) {
        if (userService.resetPassword(userId)) {
            return JsonResponse.ok();
        } else {
            return JsonResponse.errorMsg("重置失败！");
        }
    }

    /**
     * 修改用户密码
     *
     * @param userId 用户id
     * @return 修改结果
     */
    @GetMapping(value = "/modifyPassword")
    @ResponseBody
    @ApiOperation("修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "oldPassword", value = "用户旧密码", required = true, dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "newPassword", value = "用户新密码", required = true, dataType = "String", dataTypeClass = String.class)
    })
    public JsonResponse modifyPassword(Integer userId, String oldPassword, String newPassword) {
        int res = userService.modifyPassword(userId, oldPassword, newPassword);
        if (res == APPLICATION_OK) {
            return JsonResponse.ok();
        } else if (res == USER_PASSWORD_ERROR) {
            return JsonResponse.errorMsg("密码错误，修改失败！");
        } else {
            return JsonResponse.errorMsg("修改失败！");
        }
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
