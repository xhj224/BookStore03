package com.tz.online.user.dao.impl;

import com.tz.online.entity.User;
import com.tz.online.user.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 12:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {
    @Resource
    private UserDao userDao;

    @Test
    public void selectUserByName() throws Exception {
        User user = userDao.selectUserByName("jack");
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User("李三", "123123", "13344445555", "123123@qq.com", "江苏苏州", "天智");
        boolean bool = userDao.insertUser(user);
        System.out.println(bool);
    }

    @Test
    public void selectUserByNameAndPassword() throws Exception {
        User user = userDao.selectUserByNameAndPassword("张三", "123123");
        System.out.println(user);
    }
}