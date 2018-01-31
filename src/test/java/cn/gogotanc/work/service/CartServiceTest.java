package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.utils.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Test
    public void updateItem() throws Exception {
        CartItem item = new CartItem();
        item.setCount(100);
        item.setGoodsId(10000);
        item.setId(10000);
        int result = cartService.updateItem(item);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void updateCount() throws Exception {
        int result = cartService.updateCount(10000, 10000);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void deleteItem() throws Exception {
        int result = cartService.deleteItem(10000);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void getAll() throws Exception {
        List<CartItem> list = cartService.getAll();
        assertNotNull(list);
        for (CartItem item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void getAllItem() throws Exception {
        List<GoodsItem> list = cartService.getAllItem();
        assertNotNull(list);
        for (GoodsItem item : list) {
            System.out.println(item);
        }
    }

}