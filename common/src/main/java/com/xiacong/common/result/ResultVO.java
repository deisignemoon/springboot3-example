package com.xiacong.common.result;

import com.xiacong.common.constant.CommonConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * <h2></h2>
 *
 * @author yue
 * date 2023/5/31
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
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


    public static <T> ResultVO<T> ok() {
        return restResult(null, CommonConstant.SUCCESS, null);
    }

    public static <T> ResultVO<T> ok(T data) {
        return restResult(data, CommonConstant.SUCCESS, null);
    }

    public static <T> ResultVO<T> ok(T data, String msg) {
        return restResult(data, CommonConstant.SUCCESS, msg);
    }

    public static <T> ResultVO<T> failed() {
        return restResult(null, CommonConstant.FAIL, null);
    }

    public static <T> ResultVO<T> failed(String msg) {
        return restResult(null, CommonConstant.FAIL, msg);
    }

    public static <T> ResultVO<T> failed(T data) {
        return restResult(data, CommonConstant.FAIL, null);
    }

    public static <T> ResultVO<T> failed(String code, String msg) {
        return restResult(null, code, msg);
    }


    private static <T> ResultVO<T> restResult(T data, String code, String msg) {
        ResultVO<T> apiResult = new ResultVO<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
