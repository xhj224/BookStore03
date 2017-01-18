package com.tz.online.book.dao.impl;

import com.tz.online.book.dao.BookDao;
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
 * date : 2017/1/15 13:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookDaoImplTest {
    @Resource
    private BookDao bookDao;

    @Test
    public void selectBookById() throws Exception {
        Book book = bookDao.selectBookById(1L);
        if (book != null) {
            System.out.println(book);
        }
    }

    @Test
    public void selectBookByCondition() throws Exception {
        List<Book> bookList = bookDao.selectBookByCondition(2, 2, 1000001L);
        if (bookList != null) {
            bookList.forEach(System.out::println);
        }
    }

    @Test
    public void getRowCount() throws Exception {
        long count = bookDao.getRowCount(1000001L);
        System.out.println(count);
    }
}