package cn.gogotanc.work.web.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 添加商品时的表单
 *
 * @author tanc
 */
public class GoodsForm {

    @NotEmpty(message = "标题不能为空")
    @NotNull(message = "标题不能为空")
    @Length(min = 2, max = 80)
    private String goodsName;

    @NotEmpty(message = "摘要不能为空")
    @NotNull(message = "摘要不能为空")
    @Length(min = 2, max = 140)
    private String goodsSummary;

    @NotEmpty(message = "内容不能为空")
    @NotNull(message = "内容不能为空")
    @Length(min = 2, max = 1000)
    private String goodsDetail;

    @NotNull(message = "价格不能为空")
    @Min(message = "价格最小为 0", value = 0)
    private Integer goodsPrice;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSummary() {
        return goodsSummary;
    }

    public void setGoodsSummary(String goodsSummary) {
        this.goodsSummary = goodsSummary;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "GoodsForm{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsSummary='" + goodsSummary + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
