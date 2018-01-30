package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        goodsDao.insert(goods);
    }

}