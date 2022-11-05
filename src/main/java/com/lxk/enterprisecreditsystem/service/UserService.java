package com.lxk.enterprisecreditsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxk.enterprisecreditsystem.domain.User;

/**
 * @author mia
 * @description 针对表【user_table】的数据库操作Service
 * @createDate 2022-11-01 17:14:29
 */
public interface UserService extends IService<User> {

    Boolean login(User loginForm);

    Boolean register(User registerForm);
}