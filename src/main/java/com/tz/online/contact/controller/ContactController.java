package com.tz.online.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 17:36
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @RequestMapping(value = "/contactAction", method = RequestMethod.GET)
    public String contactActionGet() {
        return "/WEB-INF/jsp/other/contact.jsp";
    }
}
