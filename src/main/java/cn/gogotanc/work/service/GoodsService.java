package cn.gogotanc.work.service;

import cn.gogotanc.work.entity.Goods;

import java.util.List;

/**
 * 商品相关服务
 *
 * @author tanc
 */
public interface GoodsService {

    /**
     * 查询所有商品
     *
     * @return 返回列表
     */
    List<Goods> getAll();

    /**
     * 查询没有被买过的所有商品
     *
     * @return 商品列表
     */
    List<Goods> getUnpaied();

    /**
     * 查询单个商品
     *
     * @param id 商品的标识
     * @return 该商品的信息
     */
    Goods find(Integer id);

    /**
     * 添加商品
     *
     * @param goods 商品信息
     * @return 1 success
     */
    int add(Goods goods);

    /**
     * 更新商品
     *
     * @param goods 商品信息
     * @return 1: success, 0: failed
     */
    int update(Goods goods);

    /**
     * 删除商品信息
     *
     * @param id 商品标识
     * @return 1: success
     */
    int delete(Integer id);
}
