package com.xiacong.common.thirdinterface;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 *
 *
 * @author xiacong
 * @Classname HuaNiaoUtil
 * @Version 1.0.0
 * @Date 2024/7/25 9:39
 * @Created by xiacong
 */
@Slf4j
public class HuaNiaoUtil {

    private static String CHARSET = "UTF-8";

    private static String accountId = "DIGI_ISLAND";
    private static String key = "2cacXVAT72z87mzv";
    private static String vector = "PTRRPKmfvX3hSn8k";
    private static String signKey = "464XZK";
    private static String url = "http://124.74.46.118:8090/openapi/bridge/accept/do";




    /**
     * 签名
     * @param param
     * @return
     */
    public String sign(String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        String encryptedBody = jsonObject.getString("body");
        JSONObject header = jsonObject.getJSONObject("header");
        String accountId = header.getString("accountId");
        String serviceName = header.getString("serviceName");
        String requestTime = header.getString("requestTime");
        String version = header.getString("version");
        String signKey = "sign";
        return SecureUtil.md5(accountId + serviceName + requestTime + encryptedBody + version + signKey).toLowerCase();

    }

    /**
     * 加密方法
     *
     * @param body   要加密的数据
     * @param key  密钥，16位的数字和字母
     * @param vector     初始化向量，16位的数字和字母
     * @return
     * @throws Exception
     */
    public static String encrypt(String body, String key, String vector) {
        Assert.notNull(body, "加密数据不能为空");
        Assert.notNull(key, "密钥数据不能为空");
        Assert.notNull(vector, "初始化向量数据不能为空");
        String data = null;
        try {
            // Mode：CBC , Padding：PKCS5Padding, byte[] key, byte[] iv
            AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, key.getBytes(CHARSET),
                    vector.getBytes(CHARSET));
            String encryptedData = aes.encryptBase64(body, CHARSET);
            System.err.println("加密后data:" + encryptedData);
            return encryptedData;
        } catch (Exception e) {
            log.error("加密数据失败.被加密数据{}原因{}", data, e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * 解密方法
     *
     * @param body   要解密的数据
     * @param key  密钥，16位的数字和字母
     * @param vector     初始化向量，16位的数字和字母
     * @return
     * @throws Exception
     */
    public static String decrypt(String body, String key, String vector) {
        Assert.notNull(body, "解密数据不能为空");
        Assert.notNull(key, "密钥数据不能为空");
        Assert.notNull(vector, "初始化向量数据不能为空");
        String data = null;
        try {
            data = JSONObject.toJSONString(body);
            AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, key.getBytes(CHARSET),
                    vector.getBytes(CHARSET));
            String decryptedData = aes.decryptStr(body, Charset.forName(CHARSET));
            return decryptedData;
        } catch (Exception e) {
            log.error("解密数据失败.被解密数据{}原因{}", data, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
