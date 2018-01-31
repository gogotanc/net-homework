package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanc
 */
@Service
public class CartServiceImpl implements CartService {

    @Override
    public int addItem(CartItem item) {
        return 0;
    }

    @Override
    public int updateItem(CartItem item) {
        return 0;
    }

    @Override
    public int updateCount(Integer id, Integer count) {
        return 0;
    }

    @Override
    public int deleteItem(Integer id) {
        return 0;
    }

    @Override
    public List<CartItem> getAll() {
        return null;
    }
}
