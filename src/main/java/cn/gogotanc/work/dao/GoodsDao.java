package cn.gogotanc.work.dao;

import cn.gogotanc.work.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @return 影响的条数
     */
    int insert(Goods goods);

    /**
     * 删除一个商品
     * @param id 商品标识
     * @return 1: success
     */
    int delete(@Param("id") Integer id);

    /**
     * 更新商品信息
     * @param goods 商品信息
     * @return 1: success
     */
    int update(Goods goods);

    /**
     * 更新一系列商品的购买状态
     *
     * @param list 商品标识列表
     * @param flag 状态
     * @return !=0 success
     */
    int updateFlag(@Param("list") List<Integer> list, @Param("flag") Integer flag);

    /**
     * 获取所有商品
     * @return 商品列表
     */
    List<Goods> findAll();

    /**
     * 通过标识查找商品
     * @param id 商品标识
     * @return 商品信息
     */
    Goods findById(@Param("id") Integer id);

    /**
     * 通过 flag 查找商品
     * @param flag 购买状态
     * @return 商品列表
     */
    List<Goods> findByFlag(@Param("flag") Integer flag);
}
