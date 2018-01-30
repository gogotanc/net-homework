package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.CartItem;

/**
 * 购物车 DAO 接口
 *
 * @author tanc
 */
public interface CartItemDao {

    /**
     * 购物车新加入一个商品
     *
     * @param item 商品信息
     * @return 影响的条数
     */
    int insert(CartItem item);
}
