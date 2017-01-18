package com.tz.online.address.service.impl;

import com.tz.online.address.dao.AddressDao;
import com.tz.online.address.service.AddressService;
import com.tz.online.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 16:06.
 * Project: BookStore01.
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    @Override
    public Province findProvinceByCode(String code) {
        return addressDao.selectProvinceById(code);
    }

    @Override
    public City findCityByCode(String code) {
        return addressDao.selectCityById(code);
    }

    @Override
    public Area findAreaByCode(String code) {
        return addressDao.selectAreaById(code);
    }

    @Override
    public boolean clearDefaultAddressForUser(User user) {
        return addressDao.updateDefaultAddressForUser(user);
    }

    @Override
    public Address findDefaultAddressByUser(User user) {
        return addressDao.selectDefaultAddressByUser(user);
    }
}
