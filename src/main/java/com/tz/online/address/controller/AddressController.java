package com.tz.online.address.controller;

import com.tz.online.address.service.AddressService;
import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 16:54
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Resource
    private OrderService orderService;
    @Resource
    private AddressService addressService;

    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
    public String saveAddressGet(HttpServletRequest req, String province, String city, String area, String address_detail, String code, String reciverName, String tel, String defaultAddress) {
        String newArea = addressService.findProvinceByCode(province).getProvinceName() + addressService.findCityByCode(city).getCityName() + addressService.findAreaByCode(area).getAreaName();
        Address address = new Address(newArea, address_detail, code, reciverName, tel);
        User user = (User) req.getSession().getAttribute("userInfo");
        address.setUser(user);
        if (defaultAddress != null && defaultAddress.trim().length() > 0) {
            address.setIsDefault("1");
            addressService.clearDefaultAddressForUser(user);
        } else {
            address.setIsDefault("0");
        }
        orderService.saveAddress(address);
        return "redirect:/order/" + 1 + "/balance.do";
    }
}
