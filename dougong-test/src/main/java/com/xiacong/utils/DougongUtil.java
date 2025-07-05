package com.xiacong.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.net.BasePayRequest;
import com.huifu.bspay.sdk.opps.core.request.V2UserBasicdataEntRequest;
import com.xiacong.common.util.SequenceUtil;
import com.xiacong.config.DougongConfig;
import com.xiacong.model.dto.WxDataDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname DougongUtil
 * @Version 1.0.0
 * @Date 2025/4/25 10:54
 * @Created by xiacong
 */
@Component
@Slf4j
public class DougongUtil {
    @Resource
    private DougongConfig dougongConfig;

    private static final String JSPAY = "/v3/trade/payment/jspay";
    private static final String MERCHANT_CONFIG_QUERY = "/v2/merchant/busi/config/query";

    /**
     * 企业用户开户
     */
    private static final String COMPANT_USER_ENT = "/v2/user/basicdata/ent";

    /**
     * 修改企业用户信息
     */
    private static final String COMPANT_USER_BASE_MODIFY = "/v2/user/basicdata/ent/modify";

    /**
     * 用户业务入驻
     */
    private static final String USER_BIZ_OPEN = "/v2/user/busi/open";

    /**
     * 用户业务修改
     */
    private static final String USER_BIZ_MODIFY = "/v2/user/busi/modify";

    public Map<String, Object> orderCreate() {
        Date now = new Date();
        // 2.组装请求参数
        Map<String, Object> paramsInfo = new HashMap<>();
        // 请求日期
        paramsInfo.put("req_date", DateUtil.format(now, "yyyyMMdd"));
        // 请求流水号
        paramsInfo.put("req_seq_id", SequenceUtil.getUuIdStr());
        // 商户号
        paramsInfo.put("huifu_id", dougongConfig.getMerchantId());
        // 商品描述
        paramsInfo.put("goods_desc", "测试商品");
        // 交易类型
        paramsInfo.put("trade_type", "T_MINIAPP");
        // 交易金额
        paramsInfo.put("trans_amt", "0.01");
        // 交易有效期
        paramsInfo.put("time_expire", DateUtil.format(DateUtil.offset(now, DateField.MINUTE, 30), "yyyyMMddHHmmss"));
        WxDataDTO wxDataDTO = new WxDataDTO();
        wxDataDTO.setSub_appid(dougongConfig.getWxAppid());
        wxDataDTO.setSub_openid("o5pgR7Za1E48HcOdjgXQVhdAVf8I");
        // 微信参数集合
        paramsInfo.put("wx_data", JSONObject.toJSONString(wxDataDTO));
        // 是否延迟交易
        paramsInfo.put("delay_acct_flag", "N");
        // 分账对象
        //paramsInfo.put("acct_split_bunch", "{\"acct_infos\":[{\"div_amt\":\"0.10\",\"huifu_id\":\"6666000109133323\"}]}");
        // 传入分账遇到优惠的处理规则
        //paramsInfo.put("term_div_coupon_type", "0");
        // 禁用信用卡标记
        //paramsInfo.put("limit_pay_type", "NO_CREDIT");
        // 场景类型
        paramsInfo.put("pay_scene", "02");
        // 备注
        paramsInfo.put("remark", "string");
        // 安全信息
        //paramsInfo.put("risk_check_data", "{\"ip_addr\":\"180.167.105.130\",\"base_station\":\"192.168.1.1\",\"latitude\":\"33.3\",\"longitude\":\"33.3\"}");
        // 设备信息
        //paramsInfo.put("terminal_device_data", "{\"device_type\":\"1\",\"device_ip\":\"10.10.0.1\",\"device_gps\":\"192.168.0.0\",\"devs_id\":\"SPINTP357338300264411\"}");
        // 异步通知地址
        paramsInfo.put("notify_url", dougongConfig.getNotifyUrl());
        log.info("请求参数：{}", JSONObject.toJSONString(paramsInfo));
        // 3. 发起API调用
        Map<String, Object> response = null;
        try {
            response = BasePayRequest.requestBasePay(JSPAY, paramsInfo, dougongConfig.getSysId(), false);
        } catch (BasePayException e) {
            log.error("请求异常{}", e.getMessage());
        }
        log.info("响应参数：{}", JSONObject.toJSONString(response));
        return response;
    }

    public Map<String, Object> merchantConfigQuery() {
        Date now = new Date();
        // 2.组装请求参数
        Map<String, Object> paramsInfo = new HashMap<>();
        // 请求日期
        paramsInfo.put("req_date", DateUtil.format(now, "yyyyMMdd"));
        // 请求流水号
        paramsInfo.put("req_seq_id", SequenceUtil.getUuIdStr());
        // 商户号
        paramsInfo.put("huifu_id", dougongConfig.getMerchantId());
        // 渠道号
        //paramsInfo.put("bank_channel_no", );
        log.info("请求参数：{}", JSONObject.toJSONString(paramsInfo));
        // 3. 发起API调用
        Map<String, Object> response = null;
        try {
            response = BasePayRequest.requestBasePay(MERCHANT_CONFIG_QUERY, paramsInfo, dougongConfig.getSysId(), false);
        } catch (BasePayException e) {
            log.error("请求异常{}", e.getMessage());
        }
        log.info("响应参数：{}", JSONObject.toJSONString(response));
        return response;
    }

    public Map<String, Object> companyUserEnt() {
        Map<String, Object> params = new HashMap<>();
        params.put("req_seq_id",SequenceUtil.getUuIdStr());
        params.put("req_date",DateUtil.format(new Date(), "yyyyMMdd"));
        //营业执照
        params.put("reg_name","翁光裕");
        params.put("license_code","91330922661728867R");
        params.put("license_validity_type","1");
        params.put("license_begin_date","20141215");
        //params.put("license_end_date",SequenceUtil.getUuIdStr());
        //地区信息
        params.put("reg_prov_id","110000");
        params.put("reg_area_id","110100");
        params.put("reg_district_id","110101");
        params.put("reg_detail","菜园镇石柱村宫前巷1号村委旁");
        //法人信息
        params.put("legal_name","翁光裕");
        params.put("legal_cert_type","00");
        params.put("legal_cert_no","511423199405100017");
        params.put("legal_cert_validity_type","1");
        params.put("legal_cert_begin_date","20230406");
        // params.put("legal_cert_end_date",);
        params.put("legal_cert_nationality","CHN");
        //联系人信息
        params.put("contact_name","夏聪");
        params.put("contact_mobile","18268731097");
        params.put("contact_email","946933678@qq.com");
        //管理员账号
        //params.put("login_name","zyqd01");
        //是否发送短信
        //params.put("sms_send_flag","Y");
        //公司类型
        //params.put("ent_type","5");
        //文件列表
        //params.put("file_list",);
        log.info("请求参数：{}", JSONObject.toJSONString(params));
        // 3. 发起API调用
        Map<String, Object> response = null;
        try {
            response = BasePayRequest.requestBasePay(COMPANT_USER_ENT, params, dougongConfig.getSysId(), false);
        } catch (BasePayException e) {
            log.error("请求异常{}", e.getMessage());
        }
        log.info("响应参数：{}", JSONObject.toJSONString(response));
        return response;
    }


}
