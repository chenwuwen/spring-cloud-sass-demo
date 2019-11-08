package cn.kanyun.user.provider.controller;

import cn.kanyun.domain.User;
import cn.kanyun.user.provider.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return userService.queryAll();
    }



}
