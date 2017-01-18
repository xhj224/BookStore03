package com.tz.online.book.controller;

import com.tz.online.book.service.BookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Pageing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 15:44
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping(value = "/indexAction", method = RequestMethod.GET)
    public String indexActionGet(HttpServletRequest req, Model model) {
        // 查询出两本精选图书，三本新书，三本推荐图书
        Pageing bestBook = bookService.queryBookByCondition("1", "2", "1000003");
        Pageing newBook = bookService.queryBookByCondition("1", "3", "1000002");
        Pageing tuijianBook = bookService.queryBookByCondition("1", "3", "1000001");
        model.addAttribute("bestBook", bestBook);
        model.addAttribute("newBook", newBook);
        req.getSession().setAttribute("tuijianBook", tuijianBook);
        return "/WEB-INF/jsp/book/index.jsp";
    }

    @RequestMapping(value = "/{bookId}/detailBook", method = RequestMethod.GET)
    public String detailBookGet(@PathVariable("bookId") String bookId, Model model) {
        Book book = bookService.queryBookById(bookId);
        Pageing bookPageing = bookService.queryBookByCondition("1", "6", book.getCategory().getCateId().toString());
        model.addAttribute("bookPageing", bookPageing);
        model.addAttribute("book", book);
        return "/WEB-INF/jsp/book/detail.jsp";
    }

    @RequestMapping(value = "/{cateId}/{pageNow}/{pageSize}/viewBookByCate", method = RequestMethod.GET)
    public String viewBookByCateGet(@PathVariable("cateId") String cateId, @PathVariable("pageNow") String pageNow, @PathVariable("pageSize") String pageSize, Model model) {
        Pageing pageing = bookService.queryBookByCondition(pageNow, pageSize, cateId);
        model.addAttribute("pageing", pageing);
        return "/WEB-INF/jsp/book/specials.jsp";
    }
}
