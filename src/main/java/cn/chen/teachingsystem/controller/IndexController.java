package cn.chen.teachingsystem.controller;

import cn.chen.teachingsystem.model.JsonResponse;
import cn.chen.teachingsystem.service.UserService;
import cn.chen.teachingsystem.util.RequestContextHolderUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/13
 * @Time: 20:03
 * @Description: 入口控制器
 */
@Api(tags = "入口请求")
@Controller
public class IndexController {
    private UserService userService;

    /**
     * 请求跳转到首页
     *
     * @return 首页
     */
    @ApiOperation("请求跳转到首页")
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
    @ApiOperation("处理登录请求")
    @PostMapping(value = "/login")
    public ModelAndView login(String username, String password, int usertype) {
        ModelAndView view = new ModelAndView();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            view.setViewName("error/error");
            return view;
        }
        String result;
        if (userService.login(username, password, usertype)) {
            result = switch (usertype) {
                case 0 -> "teacher/index";
                case 1 -> "expert/index";
                case 2 -> "leader/index";
                case 3 -> "admin/index";
                case 4 -> "admin/index";
                default -> "error/error";
            };
        } else {
            result = "login";
            view.addObject("errorMsg", "登录失败！用户名或密码错误！");
        }
        view.setViewName(result);
        return view;
    }

    /**
     * 获取已登录用户的信息
     *
     * @return
     */
    @ApiOperation("获取已登录用户的信息")
    @GetMapping(value = "/getUserInformation")
    @ResponseBody
    public JsonResponse getUserInformation(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        return JsonResponse.ok(user);
    }

    /**
     * 退出登录
     *
     * @return 返回登录页面
     */
    @ApiOperation("退出登录")
    @GetMapping(value = "/signOut")
    public String signOut() {
        userService.signOut();
        return "login";
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
