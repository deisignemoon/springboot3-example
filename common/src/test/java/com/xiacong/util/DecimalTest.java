package com.xiacong.util;

import cn.hutool.core.util.NumberUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author xiacong
 * @Classname DecimalTest
 * @Version 1.0.0
 * @Date 2024/3/6 9:39
 * @Created by xiacong
 */
public class DecimalTest {
    @Test
    public void test01(){
        BigDecimal a1 = new BigDecimal("100");
        BigDecimal a2 = new BigDecimal("10.02");
        BigDecimal a3 = new BigDecimal("89.98");
        BigDecimal subtract = a1.subtract(a2);
        int i = subtract.compareTo(a3);
        System.out.println(subtract);
        System.out.println(i);
    }

    @Test
    public void test02(){
        ArrayList<String> list = new ArrayList<>();
        list.add("100");
        list.add("10.02");
        list.add("89.98");
        System.out.println(list.toArray());
        BigDecimal orderRealityPay = NumberUtil.mul(NumberUtil.div(new BigDecimal("90"),new BigDecimal("270")), new BigDecimal("270"));
        System.out.println(orderRealityPay.toString());
        BigDecimal orderRealityPay2 = NumberUtil.mul(NumberUtil.div(new BigDecimal("220"),new BigDecimal("270")), new BigDecimal("90"));
        System.out.println(orderRealityPay2.toString());
        double a=90.00d;
        double b=270.00d;
        System.out.println(a/b*b);

    }

    @Test
    public void test03(){
        BigDecimal bigDecimal = new BigDecimal("20.36");
        System.out.println(bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP));
    }
}
