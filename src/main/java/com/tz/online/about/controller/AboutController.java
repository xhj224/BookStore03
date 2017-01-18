package com.tz.online.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 16:51
 */
@Controller
@RequestMapping("/about")
public class AboutController {
    @RequestMapping(value = "/aboutAction", method = RequestMethod.GET)
    public String aboutActionGet() {
        return "/WEB-INF/jsp/other/about.jsp";
    }
}
