package com.tz.online.address.dao;

import com.tz.online.entity.*;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 15:19.
 * Project: BookStore01.
 */
public interface AddressDao {
    Province selectProvinceById(String id);

    City selectCityById(String id);

    Area selectAreaById(String id);

    boolean updateDefaultAddressForUser(User user);

    Address selectDefaultAddressByUser(User user);
}
