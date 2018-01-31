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
     * 更新一系列商品的购买状态
     *
     * @param list 商品标识列表
     * @param flag 状态
     * @return !=0 success
     */
    int updateFlag(@Param("list") List<Integer> list, @Param("flag") Integer flag);
}
