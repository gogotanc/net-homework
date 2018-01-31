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
public class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Test
    public void addItem() throws Exception {
    }

    @Test
    public void updateItem() throws Exception {
    }

    @Test
    public void updateCount() throws Exception {
    }

    @Test
    public void deleteItem() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getAllItem() throws Exception {
    }

}