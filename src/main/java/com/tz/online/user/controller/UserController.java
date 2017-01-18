package com.tz.online.user.controller;

import com.tz.online.entity.User;
import com.tz.online.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 17:20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "/WEB-INF/jsp/user/login.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet(@ModelAttribute("user") User user) {
        return "/WEB-INF/jsp/user/register.jsp";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exitGet(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        return "redirect:/book/indexAction.do";
    }

    @RequestMapping(value = "/{username}/validateName", method = RequestMethod.GET)
    public void validateNameGet(@PathVariable("username") String username, HttpServletResponse resp) throws IOException {
        username = URLDecoder.decode(username, "UTF-8");
        if (username.trim().length() != 0) {
            User user = userService.loginUser(username);
            if (user == null) {
                resp.getWriter().print("0");
            } else {
                resp.getWriter().print("1");
            }
        } else {
            resp.getWriter().print("2");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/WEB-INF/jsp/user/register.jsp";
        } else {
            System.out.println("用户:" + user);
            boolean bool = userService.registerUser(user);
            if (bool) {
                System.out.println("注册成功");
                return "redirect:/user/login.do";
            } else {
                System.out.println("注册失败");
                return "redirect:/user/register.do";
            }
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(String username, String password, String terms, HttpServletRequest req, HttpServletResponse resp, Model model) throws UnsupportedEncodingException {
        Cookie cookie;
        User user = userService.loginUserByNameAndPwd(username, password);
        if (user != null) {
            if (terms != null) {
                //说明要七天免登陆
                cookie = new Cookie("userInfo", URLEncoder.encode(username + ":" + password, "UTF-8"));
                cookie.setMaxAge(7 * 24 * 60 * 60);
                //设置Cookie作用域
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            req.getSession().setAttribute("userInfo", user);
            return "redirect:/book/indexAction.do";
        } else {
            model.addAttribute("info", "用户名或密码错误");
            return "/WEB-INF/jsp/user/login.jsp";
        }
    }
}
