package com.tz.online.address.service.impl;

import com.tz.online.address.service.AddressService;
import com.tz.online.entity.*;
import com.tz.online.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AddressServiceImplTest {

    @Resource
    private AddressService addressService;

    @Resource
    private UserService userService;

    @Test
    public void findProvinceByCode() throws Exception {
        Province province = addressService.findProvinceByCode("140000");
        System.out.println(province);
    }

    @Test
    public void findCityByCode() throws Exception {
        City city = addressService.findCityByCode("130200");
        System.out.println(city);
    }

    @Test
    public void findAreaByCode() throws Exception {
        Area area = addressService.findAreaByCode("230107");
        System.out.println(area);
    }

    @Test
    public void clearDefaultAddressForUser() throws Exception {
        User user = userService.loginUser("张三");
        boolean bool = addressService.clearDefaultAddressForUser(user);
        System.out.println(bool);
    }

    @Test
    public void findDefaultAddressByUser() throws Exception {
        User user = userService.loginUser("李四");
        Address address = addressService.findDefaultAddressByUser(user);
        System.out.println(address);
    }
}