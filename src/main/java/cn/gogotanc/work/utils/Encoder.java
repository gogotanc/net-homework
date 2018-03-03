package cn.gogotanc.work.utils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author tanc
 */
public class Encoder {

    private static final char[] HEX_DIGITS = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F',
    };

    /**
     * 使用 MD5 加密
     *
     * @param src 原内容
     * @return 大写 32 位
     */
    public static String encoderByMD5(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(src.getBytes("UTF-8"));
            return byteArray2Hex(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将 byte 数组转换成 16 进制字符串
     *
     * @param src byte 数组
     * @return 16 进制字符串
     */
    public static String byteArray2Hex(byte[] src) {

        if (null == src || src.length == 0) {
            return null;
        }

        char[] result = new char[src.length * 2];
        int index = 0;
        for (byte b : src) {
            result[index++] = HEX_DIGITS[b >> 4 & 0x0f];
            result[index++] = HEX_DIGITS[b & 0x0f];
        }
        return new String(result);
    }

    /**
     * 生成一个 UUID，没有 "-" 的形式
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 返回去掉 "-" 符号的结果
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

}
