package cn.gogotanc.work.entity;

/**
 * 用于前端显示的商品条目
 *
 * @author tanc
 */
public class GoodsItem {

    private Integer goodsId;
    private Integer itemId;
    private String title;
    private Integer price;
    private Integer count;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "GoodsItem{" +
                "goodsId=" + goodsId +
                ", itemId=" + itemId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
