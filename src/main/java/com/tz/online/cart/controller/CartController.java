package com.tz.online.cart.controller;

import com.tz.online.book.service.BookService;
import com.tz.online.entity.Book;
import com.tz.online.entity.Cart;
import com.tz.online.entity.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 17:40
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Resource
    private BookService bookService;

    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public String viewCartGet() {
        return "/WEB-INF/jsp/cart/cart.jsp";
    }

    @RequestMapping(value = "/{bookId}/addCart", method = RequestMethod.GET)
    public void addCartGet(HttpServletRequest req, HttpServletResponse resp, @PathVariable("bookId") String bookId) throws IOException {
        try {
            Book book = bookService.queryBookById(bookId);
            OrderItem item = new OrderItem(book, 1, book.getPrice());
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            cart.addCart(item);
            req.getSession().setAttribute("cart", cart);
            resp.getWriter().print("1:" + cart.getAllcount() + ":" + cart.getAllPrice());
        } catch (Exception e) {
            resp.getWriter().print("0");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{bookId}/{count}/modifyCart", method = RequestMethod.GET)
    public void modifyCartGet(HttpServletRequest req, HttpServletResponse resp, @PathVariable("bookId") String bookId, @PathVariable("count") String count) throws IOException {
        try {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.modifyCart(bookId, count);
            req.getSession().setAttribute("cart", cart);
            resp.getWriter().print("1");
        } catch (Exception e) {
            resp.getWriter().print("0");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/clearCart", method = RequestMethod.GET)
    public void clearCartGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.clearCart();
            req.getSession().setAttribute("cart", cart);
            resp.getWriter().print('1');
        } catch (Exception e) {
            resp.getWriter().print('0');
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{ids}/removeCart", method = RequestMethod.GET)
    public void removeCartGet(HttpServletRequest req, HttpServletResponse resp, @PathVariable("ids") String ids) throws IOException {
        try {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.removeCart(ids);
            req.getSession().setAttribute("cart", cart);
            resp.getWriter().print("1");
        } catch (Exception e) {
            resp.getWriter().print("0");
            e.printStackTrace();
        }
    }
}
