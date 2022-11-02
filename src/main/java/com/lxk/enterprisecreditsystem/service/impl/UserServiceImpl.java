package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.User;
import com.lxk.enterprisecreditsystem.service.UserService;
import com.lxk.enterprisecreditsystem.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【user_table】的数据库操作Service实现
* @createDate 2022-11-01 17:14:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




