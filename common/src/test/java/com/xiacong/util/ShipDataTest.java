package com.xiacong.util;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname ShopDataTest
 * @Version 1.0.0
 * @Date 2025/1/16 13:30
 * @Created by xiacong
 */
public class ShipDataTest {

    private static List<String> shopData;

    static {
        //按行读取文件字符串到shopData中
        shopData = FileUtil.readLines("file/ShipData.txt", "UTF-8");
    }

    @Test
    public void test() {
        for (String shopDatum : shopData) {
            JSONArray objects = JSONArray.parseArray(shopDatum);
            //System.out.println("存在" + objects.size() + "个船班");
            for (Object object : objects) {
                JSONObject data = (JSONObject) object;
                String lineNum = data.getString("lineNum");
                String lineName = data.getString("lineName");
                String lineNo = data.getString("lineNo");
                String lineDirect = data.getString("lineDirect");
                String startPortNo = data.getString("startPortNo");
                String startPortName = data.getString("startPortName");
                String endPortNo = data.getString("endPortNo");
                String endPortName = data.getString("endPortName");
                String shipName = data.getString("shipName");
                String sailTime = data.getString("sailTime");
                String buyTicketType = data.getString("buyTicketType");
                String clxh = data.getString("clxh");
                String clxm = data.getString("clxm");
                String hxlxh = data.getString("hxlxh");
                String hxlxm = data.getString("hxlxm");
                String freeChildCount = data.getString("freeChildCount");
                JSONArray seatClasses = data.getJSONArray("seatClasses");
                for (Object seatClass : seatClasses) {
                    JSONObject seatClassJson = (JSONObject) seatClass;
                    String classNum = seatClassJson.getString("classNum");
                    String className = seatClassJson.getString("className");
                    String totalCount = seatClassJson.getString("totalCount");
                    String totalPrice = seatClassJson.getString("totalPrice");
                    String halfPrice = seatClassJson.getString("halfPrice");
                    //System.out.println("航线号：" + lineNum + "\t\t\t航线名称：" + lineName + "\t\t\t航次：" + lineNo + "\t\t\t船名：" + shipName + "\t\t\t出发时间：" + sailTime
                    //        + "\t\t\t船票类型" + buyTicketType + "\t\t\t船类型号：" + clxh + "\t\t\t船类型名：" + clxm + "\t\t\t航线类型号：" + hxlxh + "\t\t\t航线类型名：" + hxlxm
                    //        + "\t\t\t免票儿童数量：" + freeChildCount + "\t\t\t舱位等级号：" + classNum + "\t\t\t舱位等级名:" + className + "\t\t\t当前舱位等级剩余票数：" + totalCount
                    //        + "\t\t\t实际售票价格：" + totalPrice + "\t\t\t半价：" + halfPrice);
                    //生成insert语句
                    System.out.println("INSERT INTO `ship_data` (`lineNum`, `lineName`,`startPortNo`,`startPortName`,`endPortNo`,`endPortName`,`lineDirect`, `lineNo`, `shipName`, `sailTime`, `buyTicketType`, `clxh`, `clxm`, `hxlxh`, `hxlxm`, `freeChildCount`, `classNum`, `className`, `totalCount`, `totalPrice`, `halfPrice`) VALUES ('" + lineNum + "', '" + lineName
                            + "','" + startPortNo + "','" + startPortName + "','" + endPortNo + "','" + endPortName + "','" + lineDirect + "', '" + lineNo + "', '" + shipName + "', '" + sailTime + "', '" + buyTicketType + "', '"
                            + clxh + "', '" + clxm + "', '" + hxlxh + "', '" + hxlxm + "', '" + freeChildCount + "', '" + classNum + "', '" + className + "', '" + totalCount + "', '" + totalPrice + "', '" + halfPrice + "');");
                }
            }
        }
    }

}
