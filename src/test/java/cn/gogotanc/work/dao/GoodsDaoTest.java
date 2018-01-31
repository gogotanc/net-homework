package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.utils.Constant;
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
 * 商品 DAO 单元测试
 *
 * @author tanc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
@Transactional
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void insert() throws Exception {
        Goods goods = new Goods();
        goods.setTitle("我是标题");
        goods.setSummary("我是摘要");
        goods.setContent("我是正文");
        goods.setPicture("我是个图片地址");
        goods.setPrice(10000);
        goods.setFlag(0);
        goods.setRegisterTime(new Date());
        goods.setModifyTime(new Date());
        int result = goodsDao.insert(goods);
        assertEquals(1, result);
    }

    @Test
    public void delete() throws Exception {
        int result = goodsDao.delete(10000);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void update() throws Exception {
        Goods goods = new Goods();
        goods.setId(10000);
        goods.setTitle("title");
        goods.setSummary("summary");
        goods.setContent("content");
        goods.setPicture("picture");
        goods.setPrice(11111);
        goods.setFlag(1);
        goods.setRegisterTime(new Date());
        goods.setModifyTime(new Date());
        int result = goodsDao.update(goods);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void updateFlag() throws Exception {
        List<Integer> list = new ArrayList<>(1);
        list.add(10000);
        int result = goodsDao.updateFlag(list, Constant.GOODS_FLAG_SOLD);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void findAll() throws Exception {
        List<Goods> list = goodsDao.findAll();
        assertNotNull(list);
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    @Test
    public void findById() throws Exception {
        Goods goods = goodsDao.findById(10000);
        assertNotNull(goods);
    }

    @Test
    public void findByFlag() throws Exception {
        List<Goods> list = goodsDao.findByFlag(Constant.GOODS_FLAG_UNSOLD);
        assertNotNull(list);
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }
}