package cn.gogotanc.work.entity;

import cn.gogotanc.work.utils.Constant;

import java.util.Date;

/**
 * 商品实体类
 *
 * @author tanc
 */
public class Goods {

    private Integer id;
    private String title;
    private String summary;
    private Integer price;
    private String picture;
    private String content;
    private Integer flag;
    private Date registerTime;
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPicture() {
        if (picture.startsWith(Constant.UPLOAD_FILE_PREFIX)) {
            return "/upload/" + picture;
        }
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Double getRealPrice() {
        return this.price.doubleValue() / 100.0;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", flag=" + flag +
                ", registerTime=" + registerTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
