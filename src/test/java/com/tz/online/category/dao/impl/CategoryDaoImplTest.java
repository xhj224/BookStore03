package com.tz.online.category.dao.impl;

import com.tz.online.category.dao.CategoryDao;
import com.tz.online.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryDaoImplTest {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void selectBooksForPage() throws Exception {
        List<Book> bookPageing = categoryDao.selectBooksForPage(1, 12);
        if (bookPageing != null) {
            bookPageing.forEach(System.out::println);
        }
    }

    @Test
    public void getRowCount() throws Exception {
        System.out.println(categoryDao.getRowCount());
    }
}