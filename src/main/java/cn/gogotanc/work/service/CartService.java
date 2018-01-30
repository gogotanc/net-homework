package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.CartItem;

import java.util.List;

/**
 * 购物车相关服务
 *
 * @author tanc
 */
public interface CartService {

    /**
     * 将一个商品添加进购物车
     * @param item 商品信息
     * @return 影响的条数
     */
    int addItem(CartItem item);

    /**
     * 更新一个条目
     * @param item 条目信息
     * @return 更新的结果
     */
    int updateItem(CartItem item);

    /**
     * 更新商品的数量
     * @param id 条目的标识
     * @param count 商品的数量
     * @return 更新的结果
     */
    int updateCount(Integer id, Integer count);

    /**
     * 删除一个条目
     * @param id 条目的标识
     * @return 0 异常 1 成功
     */
    int deleteItem(Integer id);

    /**
     * 获取所有的购物车条目
     * @return 返回值为列表
     */
    List<CartItem> getAll();
}
