package com.tz.online.book.service.impl;

import com.tz.online.book.service.BookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookServiceImplTest {
    @Resource
    private BookService bookService;

    @Test
    public void queryBookByCondition() throws Exception {
        Pageing pageing = bookService.queryBookByCondition("1", "2", "1000003");
        if (pageing != null) {
            System.out.println(pageing);
        }
    }

    @Test
    public void queryBookById() throws Exception {
        Book book = bookService.queryBookById("1");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("无返回结果");
        }
    }
}