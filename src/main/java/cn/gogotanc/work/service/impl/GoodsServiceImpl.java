package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanc
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public List<Goods> getAll() {
        return null;
    }

    @Override
    public List<Goods> getUnpaied() {
        return null;
    }

    @Override
    public Goods find(Integer id) {
        return null;
    }

    @Override
    public int add(Goods goods) {
        return 0;
    }

    @Override
    public int update(Goods goods) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
