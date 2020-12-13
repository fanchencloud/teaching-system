package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/13
 * @Time: 20:03
 * @Description: 入口控制器
 */
@Controller
public class IndexController {
    private UserService userService;

    /**
     * 请求跳转到首页
     *
     * @return 首页
     */
    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 处理登录请求
     *
     * @param username 用户名
     * @param password 用户密码
     * @param usertype 用户类别
     * @return 登录结果，页面跳转
     */
    @PostMapping(value = "/login")
    public String login(String username, String password, int usertype) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "error/error";
        }
        String result;
        if (userService.login(username, password, usertype)) {
            result = switch (usertype) {
                case 0 -> "teacher/index";
                case 1 -> "expert/index";
                case 2 -> "leader/index";
                case 3 -> "admin/index";
                default -> "error/error";
            };
        } else {
            result = "login";
        }
        return result;
    }

    /**
     * 请求跳转到首页
     *
     * @return 首页
     */
    @GetMapping(value = "/")
    public String loginPage1() {
        return "login";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
