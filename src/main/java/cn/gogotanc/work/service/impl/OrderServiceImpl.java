package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.dao.OrderDao;
import cn.gogotanc.work.entity.FinanceItem;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.entity.Order;
import cn.gogotanc.work.service.CartService;
import cn.gogotanc.work.service.GoodsService;
import cn.gogotanc.work.service.OrderService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private GoodsService goodsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int order() {

        List<GoodsItem> cartItems = cartService.getAllItem();
        if (null == cartItems || cartItems.size() == 0) {
            return Constant.RESULT_CODE_ERROR;
        }

        // 将购物车商品添加进订单表
        List<Order> list = Converter.items2OrderList(cartItems);
        orderDao.insertList(list);
        // 清空购物车
        cartService.clear();
        // 将商品表中的已购标志置 1
        List<Integer> ids = new ArrayList<>(list.size());
        for (Order order : list) {
            ids.add(order.getGoodsId());
        }
        goodsService.updateFlag(ids, Constant.GOODS_FLAG_SOLD);

        return Constant.RESULT_CODE_SUCCESS;
    }

    @Override
    public Order findByGoodsId(Integer goodsId) {
        return orderDao.findByGoodsId(goodsId);
    }

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.find();
    }

    @Override
    public List<FinanceItem> getAllItem() {
        return orderDao.findAllItem();
    }
}
