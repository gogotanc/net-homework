package cn.gogotanc.work.utils;

/**
 * @author tanc
 */
public class Constant {

    /**
     * 商品是否被购买的标识
     */
    public static final int GOODS_FLAG_SOLD = 1;
    public static final int GOODS_FLAG_UNSOLD = 0;

    /**
     * 用户身份标识
     */
    public static final int IDENTITY_SELLER = 1;
    public static final int IDENTITY_BUYER = 2;

    public static final String USER_SESSION_IDENTITY = "user-session-identity";

    /**
     * 通用返回结果
     */
    public static final int RESULT_CODE_ERROR = 0;
    public static final int RESULT_CODE_SUCCESS= 1;
}
