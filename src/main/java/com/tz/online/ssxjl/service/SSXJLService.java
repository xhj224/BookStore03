package com.tz.online.ssxjl.service;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;

import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:35
 */
public interface SSXJLService {
    /**
     * 查询所有省份
     */
    List<Province> findAllProvinces();

    /**
     * 根据省份编号查询城市
     */
    List<City> findCityByProvinceCode(String provinceCode);

    /**
     * 根据城市编号查询区域
     */
    List<Area> findAreaByCityCode(String cityCode);
}
