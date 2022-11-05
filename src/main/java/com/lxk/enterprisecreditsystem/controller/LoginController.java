package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.User;
import com.lxk.enterprisecreditsystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return 是否登录成功
     */
    @PostMapping("/login")
    public Boolean login(@RequestBody User loginForm) {
        return userService.login(loginForm);
    }

    /**
     * 注册
     *
     * @param registerForm 注册表单
     * @return 是否注册成功
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody User registerForm) {
        return userService.register(registerForm);
    }

}
