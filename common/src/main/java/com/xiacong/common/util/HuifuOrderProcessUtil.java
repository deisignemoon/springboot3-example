package com.xiacong.common.util;

import com.xiacong.common.constant.IslandOrderTypeEnum;
import com.xiacong.common.thirdinterface.IslandUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * @author xiacong
 * @Classname HuifuOrderProcessUtil
 * @Version 1.0.0
 * @Date 2025/9/15 8:41
 * @Created by xiacong
 */
@Component
@Slf4j
public class HuifuOrderProcessUtil {


    public List<IsOrderDTO> process(List<HuifuImportDTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        log.warn("开始处理数字海岛订单数据");
        IslandUtil islandUtil = new IslandUtil();
        List<String> orderCodes = dtos.stream().map(HuifuImportDTO::getOrderCode).collect(Collectors.toList());
        List<IsOrderDTO> isOrderDTOS = islandUtil.orderQuery(orderCodes);
        Map<String, IsOrderDTO> map = isOrderDTOS.stream().collect(Collectors.toMap(IsOrderDTO::getOrderCode, isOrderDTO -> isOrderDTO));
        for (HuifuImportDTO dto : dtos) {
            log.info("商家订单号：{},日期：{},金额：{},退款信息：{}", dto.getOrderCode(), dto.getPayDate(), dto.getOrderAmt(), dto.getRefundInfo());
            if (map.containsKey(dto.getOrderCode())) {
                IsOrderDTO isOrderDTO = map.get(dto.getOrderCode());
                log.info("数字海岛数据：实付金额：{}，类型:{}，状态：{}", isOrderDTO.getRealityPay(), IslandOrderTypeEnum.getNameByCode(isOrderDTO.getOrderType()), isOrderDTO.getStatus());
                if (isOrderDTO.getRealityPay().compareTo(new BigDecimal(dto.getOrderAmt())) != 0) {
                    log.error("数字海岛数据：商家订单号：{}金额不一致", dto.getOrderCode());
                }
            } else {
                log.error("数字海岛数据：商家订单号：{}未找到", dto.getOrderCode());
            }
        }
        log.warn("处理数字海岛订单数据完成");
        return isOrderDTOS;
    }

    public Map<String, RefundInfoDTO> refundProcess(List<HuifuImportDTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        log.warn("开始处理数字海岛退款数据");
        log.warn("数量{}", dtos.size());
        IslandUtil islandUtil = new IslandUtil();
        List<String> orderCodes = dtos.stream().map(HuifuImportDTO::getOrderCode).collect(Collectors.toList());
        List<IsRefundInfoDTO> isRefundInfoDTOS = islandUtil.refundInfoQuery(orderCodes);
        log.warn("数字海岛退款数据：{}", isRefundInfoDTOS.size());
        Map<Long, IsRefundInfoDTO> refundMap = isRefundInfoDTOS.stream().collect(Collectors.toMap(IsRefundInfoDTO::getId, isRefundInfoDTO -> isRefundInfoDTO));
        Set<String> payOrderCodes = isRefundInfoDTOS.stream().map(IsRefundInfoDTO::getOrderCode).collect(Collectors.toSet());
        List<IsOrderDTO> isOrderDTOS = islandUtil.orderQuery(new ArrayList<>(payOrderCodes));
        Map<String, IsOrderDTO> orderMap = isOrderDTOS.stream().collect(Collectors.toMap(IsOrderDTO::getOrderCode, isOrderDTO -> isOrderDTO, (k1, k2) -> {
            return k1;
        }));
        Map<String, RefundInfoDTO> resMap = new HashMap<>();
        for (HuifuImportDTO dto : dtos) {
            String refundId = dto.getOrderCode();
            if (StringUtils.startsWith(refundId, "DUP")) {
                refundId = StringUtils.replace(refundId, "DUP", "");
            }
            if (StringUtils.startsWith(refundId, "202")) {
                log.error("数字海岛数据：商家退款订单号：{}后台退款", dto.getOrderCode());
                continue;
            }
            Long id = Long.valueOf(refundId);
            if (refundMap.containsKey(id)) {
                IsRefundInfoDTO isRefundInfoDTO = refundMap.get(id);
                BigDecimal amount = isRefundInfoDTO.getAmount();
                String orderAmt = dto.getOrderAmt();
                if (amount.compareTo(new BigDecimal(orderAmt).negate()) != 0) {
                    log.error("数字海岛数据：商家订单号：{}金额不一致", dto.getOrderCode());
                }
                String orderCode = isRefundInfoDTO.getOrderCode();
                if (orderMap.containsKey(orderCode)) {
                    IsOrderDTO isOrderDTO = orderMap.get(orderCode);
                    RefundInfoDTO refundInfoDTO = null;
                    if (resMap.containsKey(orderCode)) {
                        refundInfoDTO = resMap.get(orderCode);
                    } else {
                        refundInfoDTO = new RefundInfoDTO();
                        refundInfoDTO.setOrderCode(orderCode);
                        refundInfoDTO.setOrderType(isOrderDTO.getOrderType());
                        refundInfoDTO.setAmount(isOrderDTO.getRealityPay());
                        resMap.put(orderCode, refundInfoDTO);
                    }
                    refundInfoDTO.setRefundAmount(refundInfoDTO.getRefundAmount().add(amount));
                    refundInfoDTO.setRefundIds(refundInfoDTO.getRefundIds() + id + ",");
                } else {
                    log.error("数字海岛数据：商家订单号：{}订单未找到", orderCode);
                }
            } else {
                log.error("数字海岛数据：商家退款订单号：{} 无退款流水", dto.getOrderCode());
            }
        }
        log.warn("处理数字海岛退款数据完成");
        return resMap;
    }
}
