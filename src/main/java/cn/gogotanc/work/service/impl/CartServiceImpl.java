package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.dao.CartItemDao;
import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanc
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemDao itemDao;

    @Override
    public int addItem(CartItem item) {
        return itemDao.insert(item);
    }

    @Override
    public int updateItem(CartItem item) {
        return itemDao.update(item);
    }

    @Override
    public int updateCount(Integer id, Integer count) {
        return itemDao.updateCount(id, count);
    }

    @Override
    public int deleteItem(Integer id) {
        return itemDao.delete(id);
    }

    @Override
    public List<CartItem> getAll() {
        return itemDao.find();
    }

    @Override
    public List<GoodsItem> getAllItem() {
        return itemDao.findAllItem();
    }
}
