package cn.chen.teachingsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by handsome programmer.
 *
 * @author chen
 * @User: chen
 * @Date: 2020/12/21
 * @Time: 2:32
 * @Description: 管理员页面跳转控制器
 */
@Controller
@RequestMapping(value = "/page/admin")
public class AdminPageController {

    @GetMapping(value = "/userList")
    public String userList() {
        return "admin/userList";
    }
}
