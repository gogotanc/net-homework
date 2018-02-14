package cn.gogotanc.work.utils;

import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.entity.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tanc
 */
public class Converter {

    public static Order item2Order(GoodsItem item) {
        if (null == item) {
            return null;
        }
        Order order = new Order();
        order.setPrice(item.getPrice());
        order.setGoodsId(item.getGoodsId());
        order.setCount(item.getCount());
        order.setCreateTime(new Date());
        return order;
    }

    public static List<Order> items2OrderList(List<GoodsItem> cartItems) {
        if (null == cartItems || cartItems.size() == 0) {
            return null;
        }
        List<Order> list = new ArrayList<>();
        for (GoodsItem item : cartItems) {
            list.add(item2Order(item));
        }
        return list;
    }

    /**
     * 将分为单位的价格转换成元为单位
     *
     * @param price 分为单位的价格
     * @return 元为单位的价格
     */
    public static Double price2Double(Integer price) {
        return price.doubleValue() / 100.0;
    }
}
