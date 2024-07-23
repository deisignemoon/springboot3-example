package com.xiacong.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname WaterQualityLevelUtil
 * @Version 1.0.0
 * @Date 2024/7/19 17:15
 * @Created by xiacong
 */
public class WaterQualityLevelUtil {
    private static final Map<String, List<BigDecimal>> qualityLevels = new HashMap<>();
    private static final Map<String, Boolean> bigger = new HashMap<>();

    static {
        List<BigDecimal> codLevels = new ArrayList<>();
        codLevels.add(new BigDecimal("15"));
        codLevels.add(new BigDecimal("15"));
        codLevels.add(new BigDecimal("20"));
        codLevels.add(new BigDecimal("30"));
        codLevels.add(new BigDecimal("40"));
        List<BigDecimal> woLevels = new ArrayList<>();
        woLevels.add(new BigDecimal("7.5"));
        woLevels.add(new BigDecimal("6"));
        woLevels.add(new BigDecimal("5"));
        woLevels.add(new BigDecimal("3"));
        woLevels.add(new BigDecimal("2"));
        List<BigDecimal> npLevels = new ArrayList<>();
        npLevels.add(new BigDecimal("0.15"));
        npLevels.add(new BigDecimal("0.5"));
        npLevels.add(new BigDecimal("1"));
        npLevels.add(new BigDecimal("1.5"));
        npLevels.add(new BigDecimal("2"));
        List<BigDecimal> anLevels = new ArrayList<>();
        anLevels.add(new BigDecimal("0.02"));
        anLevels.add(new BigDecimal("0.1"));
        anLevels.add(new BigDecimal("0.2"));
        anLevels.add(new BigDecimal("0.3"));
        anLevels.add(new BigDecimal("0.4"));
        List<BigDecimal> danLevels = new ArrayList<>();
        danLevels.add(new BigDecimal("0.2"));
        danLevels.add(new BigDecimal("0.5"));
        danLevels.add(new BigDecimal("1"));
        danLevels.add(new BigDecimal("1.5"));
        danLevels.add(new BigDecimal("2"));
        qualityLevels.put("含氧量", codLevels);
        qualityLevels.put("溶解氧", woLevels);
        qualityLevels.put("氨氮", woLevels);
        qualityLevels.put("总磷", anLevels);
        qualityLevels.put("总氮", danLevels);
        //含氧量越多等级越高
        bigger.put("含氧量",true);
        //含氧量越少等级越高
        bigger.put("溶解氧",false);
        //氨氮越多等级越高
        bigger.put("氨氮",true);
        //总磷越多等级越高
        bigger.put("总磷",true);
        //总氮越多等级越高
        bigger.put("总氮",true);


    }

    public static Integer checkWaterQualityLevel(String parameterName, BigDecimal value) {
        if (!qualityLevels.containsKey(parameterName)) {
            throw new IllegalArgumentException("Unknown parameter name: " + parameterName);
        }
        Boolean big = bigger.get(parameterName);
        List<BigDecimal> levelList = qualityLevels.get(parameterName);
        for (int i = 0; i < levelList.size(); i++) {
            BigDecimal bigDecimal = levelList.get(i);
            if (big) {
                if (value.compareTo(bigDecimal) <= 0) {
                    return i + 1;
                }
            } else {
                if (value.compareTo(bigDecimal) >= 0) {
                    return i + 1;
                }
            }
        }
        return levelList.size();
    }
}
