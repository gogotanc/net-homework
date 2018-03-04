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

    public static final int INDEX_TAG_ALL = 1;
    public static final int INDEX_TAG_UNSOLD = 2;

    /**
     * 存放上传文件的前缀
     */
    public static final String UPLOAD_FILE_PREFIX = "UFT-";
    public static final Integer PICTURE_TYPE_LINK = 1;
    public static final Integer PICTURE_TYPE_FILE = 2;

    /**
     * 图片文件大小限制
     */
    public static final int UPLOAD_FILE_SIZE_LIMIT = 1024 * 1024;
}
