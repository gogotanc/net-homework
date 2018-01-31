package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.Order;
import cn.gogotanc.work.utils.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml", "classpath:spring-dao.xml"})
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void order() throws Exception {
        orderService.order();
    }

    @Test
    public void add() throws Exception {
        Order order = new Order();
        order.setPrice(10000);
        order.setGoodsId(10000);
        order.setCount(1000);
        order.setCreateTime(new Date());
        int result = orderService.add(order);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void getAll() throws Exception {
        List<Order> list = orderService.getAll();
        assertNotNull(list);
        for (Order order : list) {
            System.out.println(order);
        }
    }
}