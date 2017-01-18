package com.tz.online.user.service.impl;

import com.tz.online.entity.User;
import com.tz.online.user.dao.UserDao;
import com.tz.online.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:37.
 * Project: BookStore01.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginUser(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public boolean registerUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User loginUserByNameAndPwd(String name, String password) {
        return userDao.selectUserByNameAndPassword(name, password);
    }
}
