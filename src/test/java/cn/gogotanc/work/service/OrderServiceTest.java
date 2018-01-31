package cn.gogotanc.work.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml", "classpath:spring-dao.xml"})
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void order() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}