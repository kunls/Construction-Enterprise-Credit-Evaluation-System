package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.User;
import com.lxk.enterprisecreditsystem.mapper.UserMapper;
import com.lxk.enterprisecreditsystem.service.UserService;
import com.lxk.enterprisecreditsystem.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.lxk.enterprisecreditsystem.utils.RedisConstant.USER_TYPE;

/**
 * @author mia
 * @description 针对表【user_table】的数据库操作Service实现
 * @createDate 2022-11-01 17:14:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Boolean login(User loginForm) {
        //1.验证表单是否为空
        if (loginForm == null) {
            return false;
        }
        //2.查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        String type = loginForm.getType();
        if (email != null && !email.equals("")) {
            wrapper.eq(User::getEmail, email);
        }
        User user = this.getOne(wrapper);
        //2.1若未查询到,则返回错误
        if (user == null) {
            return false;
        }
        //2.2若查到,校验密码和类型是否正确
        if (user.getPassword().equals(password) && user.getType().equals(type)) {
            //2.2.1若正确,则将该用户身份存入redis中
            stringRedisTemplate.opsForValue().set(USER_TYPE + email, type);
            //ToDo 目前用apiFox发送请求会出现线程不一致问题,待前端页面写成后再作测试
            System.out.println(Thread.currentThread().getId());
            UserHolder.saveUser(user);
            return true;
        }
        //2.2.2若不正确,返回用户名或密码不正确错误
        return false;
    }

    @Override
    public Boolean register(User registerForm) {
        //1.验证表单是否为空
        if (registerForm == null) {
            return false;
        }
        //2.查看该用户是否已注册
        String email = registerForm.getEmail();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (email != null && !email.equals("")) {
            wrapper.eq(User::getEmail, email);
        }
        User user = this.getOne(wrapper);
        //2.1如果已注册
        if (user != null) {
            return false;
        }
        //2.2如果未注册,则注册
        return this.save(registerForm);
    }
}




