package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

}