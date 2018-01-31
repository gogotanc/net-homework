package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.dao.GoodsDao;
import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.service.GoodsService;
import cn.gogotanc.work.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanc
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> getPurchasable() {
        return goodsDao.findByFlag(Constant.GOODS_FLAG_UNSELLED);
    }

    @Override
    public Goods find(Integer id) {
        return goodsDao.findById(id);
    }

    @Override
    public int add(Goods goods) {
        return goodsDao.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsDao.update(goods);
    }

    @Override
    public int updateFlag(List<Integer> ids, Integer flag) {
        if (null == ids || ids.size() == 0) {
            return Constant.RESULT_CODE_ERROR;
        }
        return goodsDao.updateFlag(ids, flag);
    }

    @Override
    public int updateFlag(Integer id, Integer flag) {
        List<Integer> list = new ArrayList<>(1);
        list.add(id);
        return updateFlag(list, flag);
    }

    @Override
    public int delete(Integer id) {
        Goods goods = goodsDao.findById(id);
        if (null == goods || goods.getFlag() == Constant.GOODS_FLAG_SELLED) {
            return Constant.RESULT_CODE_ERROR;
        }
        goodsDao.delete(id);
        return Constant.RESULT_CODE_SUCCESS;
    }
}
