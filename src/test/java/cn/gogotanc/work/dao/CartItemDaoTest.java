package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.entity.GoodsItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 购物车 DAO 单元测试
 *
 * @author tanc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
@Transactional
public class CartItemDaoTest {

    @Autowired
    private CartItemDao itemDao;

    @Test
    public void insert() throws Exception {
        CartItem item = new CartItem();
        item.setGoodsId(10000);
        item.setCount(10);
        int result = itemDao.insert(item);
        assertEquals(1, result);
    }

    @Test
    public void delete() throws Exception {
        int result = itemDao.delete(10000);
        assertEquals(1, result);
    }

    @Test
    public void update() throws Exception {
        CartItem item = new CartItem();
        item.setId(10000);
        item.setGoodsId(10000);
        item.setCount(100);
        int result = itemDao.update(item);
        assertEquals(1, result);
    }

    @Test
    public void updateCount() throws Exception {
        int result = itemDao.updateCount(10000, 300);
        assertEquals(1, result);
    }

    @Test
    public void findById() throws Exception {
        CartItem item = itemDao.findByGoodsId(10000);
        assertNotNull(item);
        System.out.println(item);
    }

    @Test
    public void findByGoodsId() throws Exception {
        CartItem item = itemDao.findByGoodsId(10000);
        assertNotNull(item);
        System.out.println(item);
    }

    @Test
    public void find() throws Exception {
        List<CartItem> list = itemDao.find();
        assertNotNull(list);
        for (CartItem item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void findAllItem() throws Exception {
        List<GoodsItem> list = itemDao.findAllItem();
        assertNotNull(list);
        for (GoodsItem item : list) {
            System.out.println(item);
        }
    }
}