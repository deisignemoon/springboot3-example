package com.xiacong.controller;

import com.xiacong.common.constant.IslandOrderTypeEnum;
import com.xiacong.common.util.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 *
 * @author xiacong
 * @Classname HuifuTestController
 * @Version 1.0.0
 * @Date 2025/9/15 9:19
 * @Created by xiacong
 */
@RestController
@RequestMapping("/huifu")
@Slf4j
public class HuifuTestController {
    @Resource
    private HuifuOrderProcessUtil huifuOrderProcessUtil;


    @PostMapping("/pay/import")
    public void importsEntity(@RequestParam("file") MultipartFile file) throws Exception {
        List<HuifuImportDTO> entities = ImportUtil.importEntities(file, HuifuImportDTO.class);
        List<IsOrderDTO> process = huifuOrderProcessUtil.process(entities);
        Map<Integer, List<IsOrderDTO>> collect = process.stream().collect(Collectors.groupingBy(IsOrderDTO::getOrderType));
        for (Map.Entry<Integer, List<IsOrderDTO>> entry : collect.entrySet()) {
            List<IsOrderDTO> value = entry.getValue();
            BigDecimal reduce = value.stream().map(IsOrderDTO::getRealityPay).reduce(BigDecimal.ZERO, BigDecimal::add);
            log.info("数字海岛订单类型：{}，数量：{},总金额：{}", IslandOrderTypeEnum.getNameByCode(entry.getKey()), value.size(),reduce);
            for (IsOrderDTO isOrderDTO : value) {
                log.info("商家订单号：{},日期：{},金额：{}", isOrderDTO.getOrderCode(), isOrderDTO.getOrderTime(), isOrderDTO.getRealityPay());
            }
        }
    }

    @PostMapping("/refund/import")
    public void refundImportsEntity(@RequestParam("file") MultipartFile file) throws Exception {
        List<HuifuImportDTO> entities = ImportUtil.importEntities(file, HuifuImportDTO.class);
        Map<String, RefundInfoDTO> map = huifuOrderProcessUtil.refundProcess(entities);
        Collection<RefundInfoDTO> values = map.values();
        Map<Integer, List<RefundInfoDTO>> collect = values.stream().collect(Collectors.groupingBy(RefundInfoDTO::getOrderType));
        for (Map.Entry<Integer, List<RefundInfoDTO>> entry : collect.entrySet()) {
            List<RefundInfoDTO> value = entry.getValue();
            BigDecimal reduce = value.stream().map(RefundInfoDTO::getRefundAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            log.info("数字海岛订单类型：{}，数量：{},总金额：{}", IslandOrderTypeEnum.getNameByCode(entry.getKey()), value.size(),reduce);
            for (RefundInfoDTO refundInfoDTO : value) {
                log.info("商家订单号：{},订单金额：{},退款金额：{},退款流水：{}", refundInfoDTO.getOrderCode()
                        ,refundInfoDTO.getAmount(), refundInfoDTO.getRefundAmount(), refundInfoDTO.getRefundIds());
            }
        }
    }
}
