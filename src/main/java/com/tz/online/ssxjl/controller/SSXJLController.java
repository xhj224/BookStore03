package com.tz.online.ssxjl.controller;

import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.ssxjl.service.SSXJLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 20:22
 */
@Controller
@RequestMapping("/ssxjl")
public class SSXJLController {

    @Resource
    private SSXJLService ssxjlService;

    @RequestMapping(value = "/findCity", method = RequestMethod.POST)
    @ResponseBody
    public List<City> findCityGet(String provinceCode) {
        return ssxjlService.findCityByProvinceCode(provinceCode);
    }

    @RequestMapping(value = "/findArea", method = RequestMethod.POST)
    @ResponseBody
    public List<Area> findAreaGet(String cityCode) {
        return ssxjlService.findAreaByCityCode(cityCode);
    }
}
