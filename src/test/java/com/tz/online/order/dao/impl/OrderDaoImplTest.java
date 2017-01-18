package com.tz.online.order.dao.impl;

import com.tz.online.entity.Address;
import com.tz.online.entity.Order;
import com.tz.online.entity.User;
import com.tz.online.order.dao.OrderDao;
import com.tz.online.user.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * project_name : BookStore03
 * user : xhj224
 * date : 2017/1/15 13:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderDaoImplTest {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;

    @Test
    public void insertAddress() throws Exception {
        User user = userDao.selectUserByName("张三");
        Address address = new Address("上海市市辖区徐汇区", "500号", "310104", "张三", "18955556666");
        address.setAddressId(2L);
        address.setIsDefault("0");
        address.setUser(user);
        orderDao.insertAddress(address);
    }

    @Test
    public void insertOrder() throws Exception {

    }

    @Test
    public void selectAddressByPage() throws Exception {
        User user = userDao.selectUserByName("李四");
        List<Address> addresses = orderDao.selectAddressByPage(user, 1, 5);
        if (addresses != null) {
            addresses.forEach(System.out::println);
        }
    }

    @Test
    public void selectOrderByPage() throws Exception {
        User user = userDao.selectUserByName("李四");
        List<Order> orders = orderDao.selectOrderByPage(user, 1, 5);
        if (orders != null) {
            System.out.println(orders.size());
        }
    }

    @Test
    public void getRowCountForAddress() throws Exception {
        User user = userDao.selectUserByName("李四");
        System.out.println(orderDao.getRowCountForAddress(user));
    }

    @Test
    public void getRowCountForOrder() throws Exception {
        User user = userDao.selectUserByName("李四");
        System.out.println(orderDao.getRowCountForOrder(user));
    }

    @Test
    public void selectAddressById() throws Exception {
        Address address = orderDao.selectAddressById(2L);
        System.out.println(address);
    }

    @Test
    public void selectOrderByOrderNum() throws Exception {
        Order order = orderDao.selectOrderByOrderNum("1482802890331");
        System.out.println(order.getOrderId());
    }

    @Test
    public void insertItem() throws Exception {

    }

}