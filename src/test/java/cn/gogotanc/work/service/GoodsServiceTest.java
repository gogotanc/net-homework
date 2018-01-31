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
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getUnpaied() throws Exception {
    }

    @Test
    public void find() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}