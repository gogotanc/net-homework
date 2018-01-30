package cn.gogotanc.work.entity;

import java.util.Date;

/**
 * 订单项目实体类
 *
 * @author tanc
 */
public class Order {

    private Integer id;
    private Integer goodsId;
    private Integer price;
    private Integer count;
    private Date createTime;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", price=" + price +
                ", count=" + count +
                ", createTime=" + createTime +
                '}';
    }
}
