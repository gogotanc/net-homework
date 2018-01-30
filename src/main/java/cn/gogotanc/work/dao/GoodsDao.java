package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Goods;

/**
 * 商品 DAO 接口
 *
 * @author tanc
 */
public interface GoodsDao {

    /**
     * 插入一个新的商品
     *
     * @param goods 商品信息
     */
    void insert(Goods goods);
}
