package com.tz.online.user.service.impl;

import com.tz.online.entity.User;
import com.tz.online.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void loginUser() throws Exception {
        User user = userService.loginUser("张三");
        if (user != null) {
            System.out.println(user);
        }
    }

    @Test
    public void registerUser() throws Exception {
        User user = new User("李四1", "123123", "13344446666", "124123@qq.com", "江苏苏州", "天智");
        boolean bool = userService.registerUser(user);
        System.out.println(bool);
    }

    @Test
    public void loginUserByNameAndPwd() throws Exception {
        User user = userService.loginUserByNameAndPwd("李四", "123123");
        System.out.println(user);
    }
}