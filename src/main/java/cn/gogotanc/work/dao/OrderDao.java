package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @return 1: success
     */
    int insert(Order order);

    /**
     * 获取所有购买记录
     *
     * @return 购买列表
     */
    List<Order> find();

    /**
     * 批量导入购物车中条目
     *
     * @param list 购买记录列表
     */
    void insertList(List<Order> list);
}
