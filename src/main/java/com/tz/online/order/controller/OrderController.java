package com.tz.online.order.controller;

import com.tz.online.address.service.AddressService;
import com.tz.online.entity.*;
import com.tz.online.order.service.OrderService;
import com.tz.online.ssxjl.service.SSXJLService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 17:30
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private SSXJLService ssxjlService;
    @Resource
    private AddressService addressService;

    @RequestMapping(value = "/{pageNow}/{pageSize}/orderList", method = RequestMethod.GET)
    public String orderListGet(HttpServletRequest req, Model model, @PathVariable("pageNow") String pageNow, @PathVariable("pageSize") String pageSize) {
        User user = (User) req.getSession().getAttribute("userInfo");
        Pageing pageingOrder = orderService.queryAllOrderByUser(user, pageNow, pageSize);
        model.addAttribute("pageingOrder", pageingOrder);
        return "/WEB-INF/jsp/order/order_list.jsp";
    }

    @RequestMapping(value = "/{pageNow}/balance", method = RequestMethod.GET)
    public String balanceGet(HttpServletRequest req, @PathVariable("pageNow") String pageNow, String ids, Model model) {
        User user = (User) req.getSession().getAttribute("userInfo");
        Address address = addressService.findDefaultAddressByUser(user);
        String pageSize;
        if (address == null) {
            pageSize = "4";
        } else {
            pageSize = "3";
        }
        Pageing addressPageing = orderService.queryAllAddressByUser(user, pageNow, pageSize);
        if (ids == null || ids.trim().length() == 0) {
            ids = (String) req.getSession().getAttribute("ids");
        }
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Cart settlementCart = cart.settlementCart(ids);
        List<Province> provinceList = ssxjlService.findAllProvinces();
        req.getSession().setAttribute("cart", cart); // 原先的购物车
        req.getSession().setAttribute("ids", ids); //　选中的商品的id字符串
        req.getSession().setAttribute("settlementCart", settlementCart); // 新的购物车
        model.addAttribute("defaultAddress", address);
        model.addAttribute("addressPageing", addressPageing);
        model.addAttribute("provinceList", provinceList);
        return "/WEB-INF/jsp/order/confirm_order.jsp";
    }

    @RequestMapping(value = "/{addressId}/saveOrder", method = RequestMethod.GET)
    public String saveOrderGET(@PathVariable("addressId") String addressId, HttpServletRequest req) {
        String base = req.getContextPath();
        // 获得地址对象
        Address address = orderService.findAddressById(addressId);
        // 获得用户对象
        User user = address.getUser();
        // 获得原始购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获得要结算的购物车
        Cart settlementCart = (Cart) req.getSession().getAttribute("settlementCart");
        // 获得订单明细集合
        Set<OrderItem> items = settlementCart.getItems();
        // 生成订单号
        String orderNum = String.valueOf(new Date().getTime());
        // 创建Order对象
        Order order = new Order(orderNum, new Date(), items, user, address, "0");
        // 将order对象存入数据库
        orderService.saveOrder(order);
        // 将订单对象与orderItem关联，并保存订单详情到数据库
        for (OrderItem item : items) {
            item.setOrder(order);
            orderService.saveOrderItem(item);
        }
        // 从原来的购物车中将已经结算的商品删除掉
        cart.removeCart((String) req.getSession().getAttribute("ids"));
        req.getSession().setAttribute("cart", cart);
        req.getSession().removeAttribute("ids");
        req.getSession().removeAttribute("settlementCart");
        return "redirect:/order/1/4/orderList.do";
    }
}
