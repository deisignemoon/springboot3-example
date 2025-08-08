package com.xiacong.http;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.thirdinterface.IslandUtil;
import com.xiacong.util.AesUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @author xiacong
 * @Classname BillTest
 * @Version 1.0.0
 * @Date 2025/4/7 16:19
 * @Created by xiacong
 */
public class BillTest {

    @Test
    public void test01() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/20250729.txt"));
        List<Object> list = new ArrayList<>();
        lines.forEach(ele -> {
            String[] split = StringUtils.split(ele, "|");
            Bill bill = new Bill();
            bill.setOrderId(StringUtils.replaceAll(split[7], " ", ""));
            bill.setPayDate(DateUtil.parse(StringUtils.replaceAll(split[0], " ", ""), "yyyy-MM-dd"));
            bill.setPayType(StringUtils.replace(split[2], " ", ""));
            bill.setPayAmt(new BigDecimal(StringUtils.replaceAll(split[3], " ", "")));
            BigDecimal a1 = new BigDecimal(StringUtils.replaceAll(split[4], " ", ""));
            BigDecimal a2 = new BigDecimal(StringUtils.replaceAll(split[5], " ", ""));
            BigDecimal a3 = new BigDecimal(StringUtils.replaceAll(split[6], " ", ""));
            bill.setHandleAme(a1.add(a2).add(a3));
            list.add(bill);
        });
        lines.close();

        //list按orderId分组未Map<c>
        Map<String, List<Bill>> map = new HashMap<>();
        list.forEach(ele -> {
            String orderId = ((Bill) ele).getOrderId();
            if (!map.containsKey(orderId)) {
                map.put(orderId, new ArrayList<>());
            }
            map.get(orderId).add((Bill) ele);
        });
        DateTime time = DateUtil.parse("2025-07-29", "yyyy-MM-dd");
        DateTime start = DateUtil.beginOfDay(time);
        DateTime end = DateUtil.endOfDay(time);
        BigDecimal total1 = BigDecimal.ZERO;
        BigDecimal total2 = BigDecimal.ZERO;

        BigDecimal orderMoney1 = BigDecimal.ZERO;
        BigDecimal quitMoney1 = BigDecimal.ZERO;
        BigDecimal chargeMoney1 = BigDecimal.ZERO;

        BigDecimal orderMoney2 = BigDecimal.ZERO;
        BigDecimal quitMoney2 = BigDecimal.ZERO;
        BigDecimal chargeMoney2 = BigDecimal.ZERO;
        for (Map.Entry<String, List<Bill>> entry : map.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            IslandUtil islandUtil = new IslandUtil();
            String json = islandUtil.invoke(key);
            JSONObject jsonObject = JSONObject.parseObject(json);
            String datas = jsonObject.getString("list");
            Assert.isTrue(StringUtils.isNotBlank(datas), key + "查询数据异常");
            List<Order> orders = JSONArray.parseArray(datas, Order.class);
            Iterator<Order> iterator = orders.iterator();
            while (iterator.hasNext()) {
                Order next = iterator.next();
                String createDate = next.getCreateDate();
                if (DateUtil.parse(createDate, "yyyy-MM-dd HH:mm:ss").isBefore(start) || DateUtil.parse(createDate, "yyyy-MM-dd HH:mm:ss").isAfter(end)) {
                    iterator.remove();
                    //System.out.println(next.getAmount() + "   " + next.getCreateDate());
                }
            }
            BigDecimal reduce2 = orders.stream().map(order -> {
                if (order.getCharge() != null) {
                    return order.getCharge();
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add);
            chargeMoney2 = chargeMoney2.add(reduce2);
            orderMoney2 = orderMoney2.add(orders.stream().map(order -> {
                if (BigDecimal.ZERO.compareTo(order.getAmount()) < 0) {
                    return order.getAmount();
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add));
            quitMoney2 = quitMoney2.add(orders.stream().map(order -> {
                if (BigDecimal.ZERO.compareTo(order.getAmount()) > 0) {
                    return order.getAmount().subtract(order.getCharge());
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add));
            BigDecimal reduce = orders.stream().map(Order::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal reduce1 = entry.getValue().stream().map(bill -> {
                return bill.getPayAmt().add(bill.getHandleAme());
            }).reduce(BigDecimal.ZERO, BigDecimal::add);
            if (reduce.compareTo(reduce1) != 0) {
                System.out.println(key + "金额异常    " + ":客运：" + reduce1 + "  海岛：" + reduce);
            } else {
                System.out.println(key + ":客运：" + reduce1 + "  海岛：" + reduce);
            }
            total1 = total1.add(reduce1);
            total2 = total2.add(reduce);
            orderMoney1 = orderMoney1.add(entry.getValue().stream().map(bill -> {
                if (StringUtils.equals(bill.getPayType(), "1")) {
                    return bill.getPayAmt();
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add));
            quitMoney1 = quitMoney1.add(entry.getValue().stream().map(bill -> {
                if (StringUtils.equals(bill.getPayType(), "-1")) {
                    return bill.getPayAmt();
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add));


            BigDecimal handleAll = entry.getValue().stream().map(bill -> {
                if (StringUtils.equals(bill.getPayType(), "-1")) {
                    return bill.getHandleAme();
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add);
            chargeMoney1 = chargeMoney1.add(handleAll);
            System.out.println(key + "客运计算手续费：" + handleAll);
            System.out.println(key + "海岛计算手续费：" + reduce2);
            if (handleAll.compareTo(reduce2) != 0) {
                System.out.println(key + "手续费计算异常");
            }
            Optional<Order> any = orders.stream().filter(o -> !StringUtils.equals(o.getMerchantId(), "1737375026908958722")).findAny();
            if (any.isPresent()) {
                System.out.println(key + "商户异常：" + any.get().getMerchantId());
            }
        }
        System.out.println("客运总计：" + total1 + "  海岛总计：" + total2);

        System.out.println("客运：" + orderMoney1 + "  退费：" + quitMoney1 + "  手续费：" + chargeMoney1);
        System.out.println("海岛：" + orderMoney2 + "  退费：" + quitMoney2 + "  手续费：" + chargeMoney2);
    }

    @Test
    public void test02() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/20250731.txt"));
        List<Bill> list = new ArrayList<>();
        lines.forEach(ele -> {
            String[] split = StringUtils.split(ele, "|");
            Bill bill = new Bill();
            bill.setOrderId(StringUtils.replaceAll(split[7], " ", ""));
            bill.setPayDate(DateUtil.parse(StringUtils.replaceAll(split[0], " ", ""), "yyyy-MM-dd"));
            bill.setPayType(StringUtils.replace(split[2], " ", ""));
            bill.setPayAmt(new BigDecimal(StringUtils.replaceAll(split[3], " ", "")));
            BigDecimal a1 = new BigDecimal(StringUtils.replaceAll(split[4], " ", ""));
            BigDecimal a2 = new BigDecimal(StringUtils.replaceAll(split[5], " ", ""));
            BigDecimal a3 = new BigDecimal(StringUtils.replaceAll(split[6], " ", ""));
            bill.setHandleAme(a1.add(a2).add(a3));
            list.add(bill);
        });
        lines.close();

        Set<String> refundOrderId = list.stream().map(bill -> {
            //if (StringUtils.equals(bill.getPayType(), "-1")) {
            //    return bill.getOrderId();
            //}
            //return null;
            return bill.getOrderId();
        }).filter(Objects::nonNull).collect(Collectors.toSet());
        System.out.println(refundOrderId);
        System.out.println(refundOrderId.size());
        //IslandUtil islandUtil = new IslandUtil();
        //for (String s : refundOrderId) {
        //    String data = islandUtil.invoke2(s);
        //    JSONObject jsonObject = JSONObject.parseObject(data);
        //    JSONArray list1 = jsonObject.getJSONArray("list");
        //    for (Object o : list1) {
        //        JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
        //        String string = jsonObject1.getString("itemState");
        //        if (!StringUtils.equals(string, "7")) {
        //            System.out.println(jsonObject1.getString("orderId")+"    "+jsonObject1.getString("id")+"   "+jsonObject1.getString("itemState"));
        //        }
        //    }
//
        //}
    }

    @Test
    public void test03() throws IOException {
        String filePath = "src/test/resources/file/嵊泗客运.txt";
        Map<String, List<Bill>> billMap = getBillMap(filePath);
        String errorFilePath = "src/test/resources/file/20250426errorcode.txt";
        Set<String> errorCodes = errorOrderCode(errorFilePath);
        for (String errorCode : errorCodes) {
            IslandUtil islandUtil = new IslandUtil();
            String json = islandUtil.invoke(errorCode);
            JSONObject jsonObject = JSONObject.parseObject(json);
            String datas = jsonObject.getString("list");
            Assert.isTrue(StringUtils.isNotBlank(datas), errorCode + "查询数据异常");
            List<Order> orders = JSONArray.parseArray(datas, Order.class);
            String ordersState = islandUtil.invoke2(errorCode);
            JSONObject ordersStateJson = JSONObject.parseObject(ordersState);
            String details = ordersStateJson.getString("list");
            Assert.isTrue(StringUtils.isNotBlank(details), errorCode + "查询数据异常");
            List<OrderDetail> orderDetails = JSONArray.parseArray(details, OrderDetail.class);
            String sskyOrder = islandUtil.invoke3(errorCode);
            JSONObject sskyOrderJson = JSONObject.parseObject(sskyOrder);
            String itemList = sskyOrderJson.getString("orderItemList");
            List<Item> items = null;
            if (StringUtils.isNotBlank(itemList)) {
                items = JSONArray.parseArray(itemList, Item.class);
            }
            System.out.println(errorCode);
            System.out.println("客运流水：");
            BigDecimal total = BigDecimal.ZERO;
            if (billMap.containsKey(errorCode)) {
                for (Bill bill : billMap.get(errorCode)) {
                    System.out.println("\t" + bill.getPayDate() + ":" + bill.getPayAmt() + "  " + bill.getHandleAme());
                    if (bill.getPayAmt().compareTo(BigDecimal.ZERO) < 0 && bill.getPayDate().before(DateUtil.parse("2025-04-26 23:00:00", "yyy-MM-dd HH:mmss"))) {
                        total = total.add(bill.getPayAmt());
                    }
                }
            } else {
                System.out.println("\t客运无流水");
            }
            System.out.println("客运船票状态：" + sskyOrderJson.getString("orderState"));
            if (!CollectionUtils.isEmpty(items)) {
                for (Item item : items) {
                    System.out.println("\t" + item.getItemState());
                }
            }
            System.out.println("海岛流水：");
            for (Order order : orders) {
                System.out.println("\t" + order.getCreateDate() + ":" + order.getAmount() + "  " + order.getOrderAmount() + "  " + order.getCharge());
            }
            System.out.println("海岛详情：");
            for (OrderDetail orderDetail : orderDetails) {
                System.out.println("\t" + orderDetail.getItemStateName());
            }
            System.out.println("---------------------------------");
        }

    }

    @Test
    public void test04() throws IOException {
        String filePath = "src/test/resources/file/嵊泗客运.txt";
        Map<String, List<Bill>> billMap = getBillMap(filePath);
        String errorFilePath = "src/test/resources/file/20250426errorcode.txt";
        Set<String> errorCodes = errorOrderCode(errorFilePath);
        BigDecimal total = BigDecimal.ZERO;
        for (String errorCode : errorCodes) {
            if (billMap.containsKey(errorCode)) {
                for (Bill bill : billMap.get(errorCode)) {
                    if (bill.getPayAmt().compareTo(BigDecimal.ZERO) < 0
                            && bill.getPayDate().before(DateUtil.parse("2025-04-26 23:00:00", "yyy-MM-dd HH:mm:ss"))
                            && bill.getPayDate().after(DateUtil.parse("2025-04-25 23:00:00", "yyy-MM-dd HH:mm:ss"))) {
                        System.out.println("\t" + bill.getOrderId() + ":" + bill.getPayAmt());
                        total = total.add(bill.getPayAmt());
                    }
                }
            }
        }
        System.out.println(total);
    }

    Set<String> errorOrderCode(String filePath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        Set<String> set = new HashSet<String>();
        lines.forEach(ele -> {
            set.add(ele);
        });
        lines.close();
        return set;
    }


    private Map<String, List<Bill>> getBillMap(String filePath) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filePath));
        List<Object> list = new ArrayList<>();
        lines.forEach(ele -> {
            String[] split = StringUtils.split(ele, "|");
            Bill bill = new Bill();
            bill.setOrderId(StringUtils.replaceAll(split[7], " ", ""));
            bill.setPayDate(DateUtil.parse(StringUtils.replaceAll(split[0], " ", ""), "yyyy-MM-dd"));
            bill.setPayType(StringUtils.replace(split[2], " ", ""));
            bill.setPayAmt(new BigDecimal(StringUtils.replaceAll(split[3], " ", "")));
            BigDecimal a1 = new BigDecimal(StringUtils.replaceAll(split[4], " ", ""));
            BigDecimal a2 = new BigDecimal(StringUtils.replaceAll(split[5], " ", ""));
            BigDecimal a3 = new BigDecimal(StringUtils.replaceAll(split[6], " ", ""));
            bill.setHandleAme(a1.add(a2).add(a3));
            list.add(bill);
        });
        lines.close();

        //list按orderId分组未Map<c>
        Map<String, List<Bill>> map = new HashMap<>();
        list.forEach(ele -> {
            String orderId = ((Bill) ele).getOrderId();
            if (!map.containsKey(orderId)) {
                map.put(orderId, new ArrayList<>());
            }
            map.get(orderId).add((Bill) ele);
        });
        return map;
    }

    @Test
    public void aesTest(){
        String str= "6_sRo0Z6dp9slYj0DUuDmg==";
        String decrypt = AesUtil.decrypt(str);
        System.out.println(decrypt);
    }

}
