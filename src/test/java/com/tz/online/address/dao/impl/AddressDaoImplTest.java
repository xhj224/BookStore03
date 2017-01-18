package com.tz.online.address.dao.impl;

import com.tz.online.address.dao.AddressDao;
import com.tz.online.entity.*;
import com.tz.online.user.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 12:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddressDaoImplTest {
    @Resource
    private AddressDao addressDao;
    @Resource
    private UserDao userDao;

    @Test
    public void selectProvinceById() throws Exception {
        Province province = addressDao.selectProvinceById("140000");
        System.out.println(province);
    }

    @Test
    public void selectCityById() throws Exception {
        City city = addressDao.selectCityById("130200");
        System.out.println(city);
    }

    @Test
    public void selectAreaById() throws Exception {
        Area area = addressDao.selectAreaById("230107");
        System.out.println(area);
    }

    @Test
    public void selectDefaultAddressByUser() throws Exception {
        User user = userDao.selectUserByName("smith");
        Address address = addressDao.selectDefaultAddressByUser(user);
        System.out.println(address);
    }
}