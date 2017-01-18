package com.tz.online.ssxjl.service.impl;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.SSXJLDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSXJLServiceImplTest {

    @Resource
    private SSXJLDao ssxjlDao;

    @Test
    public void findAllProvinces() throws Exception {
        List<Province> provinceList = ssxjlDao.selectAllProvinces();
        if (provinceList != null) {
            provinceList.forEach(System.out::println);
        }
    }

    @Test
    public void findCityByProvinceCode() throws Exception {
        List<City> cityList = ssxjlDao.selectCityByProvinceCode("130000");
        if (cityList != null) {
            cityList.forEach(System.out::println);
        }
    }

    @Test
    public void findAreaByCityCode() throws Exception {
        List<Area> areaList = ssxjlDao.selectAreaByCityCode("230100");
        if (areaList != null) {
            areaList.forEach(System.out::println);
        }
    }
}