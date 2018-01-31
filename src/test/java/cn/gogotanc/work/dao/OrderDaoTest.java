package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 购买记录 DAO 单元测试类
 *
 * @author tanc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
@Transactional
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void insert() throws Exception {
        Order order = new Order();
        order.setGoodsId(10000);
        order.setCount(10);
        order.setPrice(10000);
        order.setCreateTime(new Date());
        int result = orderDao.insert(order);
        assertEquals(1, result);
    }

    @Test
    public void insertList() throws Exception {
        List<Order> list = new ArrayList<>();
        Order one = new Order();
        one.setCreateTime(new Date());
        one.setCount(100);
        one.setGoodsId(10000);
        one.setPrice(10000);
        Order two = new Order();
        two.setCreateTime(new Date());
        two.setCount(111);
        two.setGoodsId(11111);
        two.setPrice(11111);
        list.add(one);
        list.add(two);
        orderDao.insertList(list);
        // orderDao.insertList(null);
        // null 或者 list size 为 0 都会出错哟
    }

    @Test
    public void find() throws Exception {
        List<Order> list = orderDao.find();
        assertNotNull(list);
        for (Order order : list) {
            System.out.println(order);
        }
    }
}