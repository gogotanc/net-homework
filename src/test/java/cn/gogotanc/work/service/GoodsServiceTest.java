package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.utils.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml", "classpath:spring-dao.xml"})
@Transactional
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void updateFlag() throws Exception {
        List<Integer> list = new ArrayList<>(1);
        list.add(10000);
        int result = goodsService.updateFlag(list, Constant.GOODS_FLAG_SELLED);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

    @Test
    public void delete() throws Exception {
        int result = goodsService.delete(10000);
        assertEquals(Constant.RESULT_CODE_SUCCESS, result);
    }

}