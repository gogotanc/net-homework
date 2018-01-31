package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.entity.GoodsItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 删除条目
     * @param id 条目标识
     * @return 1: success
     */
    int delete(@Param("id") Integer id);

    /**
     * 删除所有记录
     */
    void deleteAll();

    /**
     * 更新条目
     * @param item 条目信息
     * @return 1: success
     */
    int update(CartItem item);

    /**
     * 更新条目中商品数量
     * @param id 条目标识
     * @param count 商品数量
     * @return 1:success
     */
    int updateCount(@Param("id")Integer id, @Param("count")Integer count);

    /**
     * 通过条目标识查找条目
     * @param id 条目标识
     * @return 条目信息
     */
    CartItem findById(@Param("id") Integer id);

    /**
     * 通过商品标识查找条目
     * @param goodsId 商品标识
     * @return 条目信息
     */
    CartItem findByGoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 获取所有条目
     * @return 条目列表
     */
    List<CartItem> find();

    /**
     * 获取所有条目，用于显示
     * @return 条目列表
     */
    List<GoodsItem> findAllItem();
}
