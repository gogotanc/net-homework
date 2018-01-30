package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Order;

/**
 * 订单 DAO 接口
 *
 * @author tanc
 */
public interface OrderDao {

    /**
     * 添加一条购买记录
     *
     * @param order 订单信息
     * @return 影响的条数
     */
    int insert(Order order);
}
