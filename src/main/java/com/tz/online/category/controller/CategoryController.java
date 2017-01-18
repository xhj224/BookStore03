package com.tz.online.category.controller;

import com.tz.online.category.service.CategoryService;
import com.tz.online.entity.Pageing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 17:09
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/{pageNow}/{pageSize}/showCategory", method = RequestMethod.GET)
    public String showCategoryGet(@PathVariable("pageNow") String pageNow, @PathVariable("pageSize") String pageSize, Model model) {
        Pageing bookPageing = categoryService.findBooksByPage(pageNow, pageSize);
        model.addAttribute("bookPageing", bookPageing);
        return "/WEB-INF/jsp/book/category.jsp";
    }
}
