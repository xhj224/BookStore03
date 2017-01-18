package com.tz.online.category.service.impl;

import com.tz.online.category.service.CategoryService;
import com.tz.online.entity.Pageing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryServiceImplTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void findBooksByPage() throws Exception {
        Pageing pageing = categoryService.findBooksByPage("1", "5");
        System.out.println(pageing);
    }

}