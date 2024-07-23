package com.xiacong.util;

import com.xiacong.common.util.WaterQualityLevelUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname WaterTest
 * @Version 1.0.0
 * @Date 2024/7/19 17:44
 * @Created by xiacong
 */
public class WaterTest {
    @Test
    public void test09(){
        Integer count = WaterQualityLevelUtil.checkWaterQualityLevel("含氧量", new BigDecimal("45"));
        System.out.println(count);
        Integer count2 = WaterQualityLevelUtil.checkWaterQualityLevel("溶解氧", new BigDecimal("3"));
        System.out.println(count2);
        Integer count3 = WaterQualityLevelUtil.checkWaterQualityLevel("氨氮", new BigDecimal("0.5"));
        System.out.println(count3);
        Integer count4 = WaterQualityLevelUtil.checkWaterQualityLevel("总磷", new BigDecimal("0.5"));
        System.out.println(count4);
        Integer count5 = WaterQualityLevelUtil.checkWaterQualityLevel("总氮", new BigDecimal("0.5"));
        System.out.println(count5);
    }
}
