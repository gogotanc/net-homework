package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.utils.Constant;
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
        CartItem item = new CartItem();
        item.setCount(100);
        item.setGoodsId(10000);
        int result = cartService.addItem(item);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }
}