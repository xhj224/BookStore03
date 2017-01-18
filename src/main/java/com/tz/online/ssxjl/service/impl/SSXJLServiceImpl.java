package com.tz.online.ssxjl.service.impl;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.SSXJLDao;
import com.tz.online.ssxjl.service.SSXJLService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:37
 */
@Service
public class SSXJLServiceImpl implements SSXJLService {

    @Resource
    private SSXJLDao ssxjlDao;

    @Override
    public List<Province> findAllProvinces() {
        return ssxjlDao.selectAllProvinces();
    }

    @Override
    public List<City> findCityByProvinceCode(String provinceCode) {
        return ssxjlDao.selectCityByProvinceCode(provinceCode);
    }

    @Override
    public List<Area> findAreaByCityCode(String cityCode) {
        return ssxjlDao.selectAreaByCityCode(cityCode);
    }
}
