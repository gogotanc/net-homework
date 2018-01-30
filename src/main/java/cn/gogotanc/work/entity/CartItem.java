package cn.gogotanc.work.entity;

/**
 * 购物车条目实体类
 *
 * @author tanc
 */
public class CartItem {

    private Integer id;
    private Integer goodsId;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", count=" + count +
                '}';
    }
}
