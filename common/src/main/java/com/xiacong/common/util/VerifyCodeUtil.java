package com.xiacong.common.util;

import java.util.Random;


/**
 * 验证码生成器
 * --------------------------------------------------------------------------------------------------------------
 * 可生成数字、大写、小写字母及三者混合类型的验证码
 * 支持自定义验证码字符数量,支持自定义验证码图片的大小,支持自定义需排除的特殊字符,支持自定义干扰线的数量,支持自定义验证码图文颜色
 * --------------------------------------------------------------------------------------------------------------
 *
 * @author yue
 * @date 2023/6/1 9:59
 */
public class VerifyCodeUtil {
    /**
     * 验证码类型为仅数字,即0~9
     */
    public static final int TYPE_NUM_ONLY = 0;

    /**
     * 验证码类型为仅字母,即大小写字母混合
     */
    public static final int TYPE_LETTER_ONLY = 1;

    /**
     * 验证码类型为数字和大小写字母混合
     */
    public static final int TYPE_ALL_MIXED = 2;

    /**
     * 验证码类型为数字和大写字母混合
     */
    public static final int TYPE_NUM_UPPER = 3;

    /**
     * 验证码类型为数字和小写字母混合
     */
    public static final int TYPE_NUM_LOWER = 4;

    /**
     * 验证码类型为仅大写字母
     */
    public static final int TYPE_UPPER_ONLY = 5;

    /**
     * 验证码类型为仅小写字母
     */
    public static final int TYPE_LOWER_ONLY = 6;

    private VerifyCodeUtil() {
    }


    /**
     * 生成验证码字符串
     *
     * @param type          验证码类型,参见本类的静态属性
     * @param length        验证码长度,要求大于0的整数
     * @param excludeString 需排除的特殊字符（无需排除则为null）
     * @return 验证码字符串
     */
    public static String generateTextCode(int type, int length, String excludeString) {
        if (length <= 0) {
            return "";
        }
        StringBuilder verifyCode = new StringBuilder();
        int i = 0;
        Random random = new Random();
        switch (type) {
            case TYPE_NUM_ONLY:
                while (i < length) {
                    int t = random.nextInt(10);
                    //排除特殊字符
                    if (null == excludeString || excludeString.indexOf(t + "") < 0) {
                        verifyCode.append(t);
                        i++;
                    }
                }
                break;
            case TYPE_LETTER_ONLY:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97 || (t >= 65 && t <= 90)) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case TYPE_ALL_MIXED:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97 || (t >= 65 && t <= 90) || (t >= 48 && t <= 57)) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_UPPER:
                while (i < length) {
                    int t = random.nextInt(91);
                    if ((t >= 65 || (t >= 48 && t <= 57)) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_LOWER:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97 || (t >= 48 && t <= 57)) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case TYPE_UPPER_ONLY:
                while (i < length) {
                    int t = random.nextInt(91);
                    if ((t >= 65) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            case TYPE_LOWER_ONLY:
                while (i < length) {
                    int t = random.nextInt(123);
                    if ((t >= 97) && (null == excludeString || excludeString.indexOf((char) t) < 0)) {
                        verifyCode.append((char) t);
                        i++;
                    }
                }
                break;
            default:
                break;
        }
        return verifyCode.toString();
    }

}
