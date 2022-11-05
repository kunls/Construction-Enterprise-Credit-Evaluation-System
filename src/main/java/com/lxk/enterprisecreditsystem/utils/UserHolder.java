package com.lxk.enterprisecreditsystem.utils;

import com.lxk.enterprisecreditsystem.domain.User;

/**
 * 保存全局用户对象
 */
public class UserHolder {
    private final static ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user) {
        System.out.println("保存了user" + user);
        tl.set(user);
    }

    public static User getUser() {
        System.out.println("获得了user" + tl.get());
        return tl.get();
    }

    public static void removeUser() {
        tl.remove();
    }
}
