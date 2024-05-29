package com.xiacong.common.result;

import com.xiacong.common.constant.CommonConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * <h2></h2>
 *
 * @author wangp
 * date 2023/6/1
 */
@Data
public class RpcResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 成功标记:200
     * 失败标记:400
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;


    public static <T> RpcResultVO<T> ok() {
        return restResult(null, CommonConstant.SUCCESS, null, true);
    }

    public static <T> RpcResultVO<T> ok(T data) {
        return restResult(data, CommonConstant.SUCCESS, null, true);
    }

    public static <T> RpcResultVO<T> ok(T data, String msg) {
        return restResult(data, CommonConstant.SUCCESS, msg, true);
    }

    public static <T> RpcResultVO<T> failed() {
        return restResult(null, CommonConstant.FAIL, null, false);
    }

    public static <T> RpcResultVO<T> failed(String msg) {
        return restResult(null, CommonConstant.FAIL, msg, false);
    }

    public static <T> RpcResultVO<T> failed(T data) {
        return restResult(data, CommonConstant.FAIL, null, false);
    }

    public static <T> RpcResultVO<T> failed(String code, String msg) {
        return restResult(null, code, msg, false);
    }


    private static <T> RpcResultVO<T> restResult(T data, String code, String msg, Boolean success) {
        RpcResultVO<T> apiResult = new RpcResultVO<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


}
