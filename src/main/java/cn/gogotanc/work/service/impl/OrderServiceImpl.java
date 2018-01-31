package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.dao.OrderDao;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.entity.Order;
import cn.gogotanc.work.service.CartService;
import cn.gogotanc.work.service.OrderService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanc
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    @Override
    public int order() {
        List<GoodsItem> cartItems = cartService.getAllItem();
        if (null == cartItems || cartItems.size() == 0) {
            return Constant.RESULT_CODE_ERROR;
        }
        List<Order> list = Converter.items2OrderList(cartItems);
        orderDao.insertList(list);
        return Constant.RESULT_CODE_SUCCESS;
    }

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.find();
    }
}
