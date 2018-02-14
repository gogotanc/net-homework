package cn.gogotanc.work.entity;

import java.util.Date;

/**
 * 用于财务页面显示的 vo
 *
 * @author tanc
 */
public class FinanceItem {

    private String title;
    private Integer price;
    private Integer count;
    private Date createTime;
    private String picture;

    /**
     * 返回元为单位的价格
     */
    public Double getRealPrice() {
        return this.price.doubleValue() / 100.0;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "FinanceItem{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", createTime=" + createTime +
                ", picture='" + picture + '\'' +
                '}';
    }
}
