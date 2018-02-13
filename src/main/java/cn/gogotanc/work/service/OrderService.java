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
     * @return 1: success
     */
    int order();

    /**
     * 通过商品标识查找订单信息
     *
     * @param goodsId 商品标识
     * @return 订单信息
     */
    Order findByGoodsId(Integer goodsId);

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
