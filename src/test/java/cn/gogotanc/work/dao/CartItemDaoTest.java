package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

}