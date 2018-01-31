package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.Order;

import java.util.List;

/**
 * 订单服务
 *
 * @author tanc
 */
public interface OrderService {

    /**
     * 下单：将购物车内容写进订单
     */
    int order();

    /**
     * 添加购买记录
     *
     * @param order 购买记录
     * @return 1: success
     */
    int add(Order order);

    /**
     * 查询所有购买记录
     *
     * @return 购买记录列表
     */
    List<Order> getAll();
}
