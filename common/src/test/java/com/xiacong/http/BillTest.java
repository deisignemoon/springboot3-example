package com.xiacong.http;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.DateUtils;
import com.xiacong.common.constant.IslandOrderTypeEnum;
import com.xiacong.common.thirdinterface.IslandUtil;
import com.xiacong.common.util.*;
import com.xiacong.util.AesUtil;
import com.xiacong.util.IcbcFLowData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
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
@Slf4j
public class BillTest {

    @Test
    public void test01() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/20251114.txt"));
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
        DateTime time = DateUtil.parse("2025-11-14", "yyyy-MM-dd");
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
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/20251114.txt"));
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


    private List<String> getOrdeCodes() {
        List<String> orderCodes = new ArrayList<>();
        //orderCodes.add("217558184928301889");
        //orderCodes.add("217557609617134431");
        //orderCodes.add("217557658387271366");
        //orderCodes.add("217559541603097427");
        //orderCodes.add("217559541663098685");
        //orderCodes.add("217554716245679118");
        //orderCodes.add("217559465282923823");
        //orderCodes.add("217559465222922495");
        //orderCodes.add("217558727771172603");
        //orderCodes.add("217557856117884516");
        orderCodes.add("217559193402220828");
        //orderCodes.add("217558652729988849");
        //orderCodes.add("217559352722708313");
        //orderCodes.add("217558419619370970");
        //orderCodes.add("217554717975877162");
        //orderCodes.add("217556000912140779");
        //orderCodes.add("217554732456151522");
        //orderCodes.add("217558301308873835");
        //orderCodes.add("217555763871098195");
        //orderCodes.add("217559528133052492");
        //orderCodes.add("217559528193053482");
        //orderCodes.add("217559118351938102");
        return orderCodes;
    }

    @Test
    public void test09() throws Exception {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/20251114.txt"));
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
        List<String> ordeCodes = getOrdeCodes();
        BigDecimal total = BigDecimal.ZERO;
        for (String orderCode : ordeCodes) {
            List<Bill> bills = map.get(orderCode);
            BigDecimal zero = BigDecimal.ZERO;
            for (Bill bill : bills) {
                if (bill.getPayType().equals("-1")) {
                    total = total.add(bill.getPayAmt());
                    zero = zero.add(bill.getPayAmt());
                }
            }
            System.out.println(zero);
        }
        System.out.println("total=" + total);
    }

    @Test
    public void test10() {
        IslandUtil islandUtil = new IslandUtil();
        String json = islandUtil.invoke("217559193402220828");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String datas = jsonObject.getString("list");
        System.out.println(datas);
    }

    @Test
    public void aesTest() throws Exception {
        //String str = "kltEUNO4_3y9ihtsA5ep7w==";
        //String decrypt = AesUtil.decrypt(str);
        //System.out.println(decrypt);

        //String encrypt = AesUtil.encrypt("330903199211010213");
        //System.out.println(encrypt);


        String names = "王佳琪,卢梦雨,吴泓,王颖,吴昕烨,陈咪咪,赵良,赵良,赵辉,陈桂华,赵槿梵,柳红兵,李敏,柳尚均,柳尚言,金歆怡,陈涵,张宏梅,金水明";
        String[] split = StringUtils.split(names, ",");
        for (String s : split) {
            System.out.println(AesUtil.encrypt(s));
        }
        //Long id = null;
        //long maxDatacenterId = 21;
        //InetAddress ip = InetAddress.getLocalHost();
        //NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        //if (network == null) {
        //    id = 1L;
        //} else {
        //    byte[] mac = network.getHardwareAddress();
        //    for (byte b : mac) {
        //        System.out.println(b);
        //    }
        //    if (null != mac) {
        //        id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
        //        id = id % (maxDatacenterId + 1);
        //    }
        //}
        //System.out.println(id);

        System.out.println(AesUtil.encrypt("150103195409112519"));
    }

    @Test
    public void cut() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/all.txt"));
        Stream<String> cut = Files.lines(Paths.get("src/test/resources/file/cut.txt"));
        Set<String> cutSet = cut.collect(Collectors.toSet());
        Set<String> allset = all.collect(Collectors.toSet());
        for (String s : allset) {
            if (!cutSet.contains(s)) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void processScenic() throws Exception {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/file/0726-0825.txt"));
        List<ScenicOrder> list = new ArrayList<>();
        lines.forEach(ele -> {
            String[] split = StringUtils.split(ele, "|");
            ScenicOrder bill = new ScenicOrder();
            bill.setOrderCode(StringUtils.replaceAll(split[1], " ", ""));
            bill.setSailId(StringUtils.replaceAll(split[3], " ", ""));
            bill.setSailTicketId(StringUtils.replace(split[4], " ", ""));
            bill.setAmt(new BigDecimal(StringUtils.replaceAll(split[5], " ", "")));
            bill.setStatus(StringUtils.replace(split[6], " ", ""));
            bill.setPhoneNo(AesUtil.decrypt(StringUtils.replace(split[7], " ", "")));
            bill.setCreateTime(DateUtil.parse(split[8], "yyyy-MM-dd HH:mm:ss"));
            list.add(bill);
        });
        lines.close();
        Map<String, List<ScenicOrder>> map = list.stream().collect(Collectors.groupingBy(ScenicOrder::getStatus));
        for (Map.Entry<String, List<ScenicOrder>> entry : map.entrySet()) {
            List<ScenicOrder> value = entry.getValue();
            BigDecimal reduce = value.stream().map(ScenicOrder::getAmt).reduce(BigDecimal.ZERO, BigDecimal::add);
            log.info("订单状态：{}，数量：{},金额：{}", entry.getKey(), value.size(), reduce);
        }
    }

    @Test
    public void user() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/user.txt"));
        Set<String> allset = all.collect(Collectors.toSet());
        for (String s : allset) {
            String[] strings = StringUtils.splitByWholeSeparator(s, null);
            log.info("用户：{}，密码：{}", strings[0], AesUtil.decrypt(strings[1]));
        }
    }

    @Test
    public void merchant() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/merchant.txt"));
        Set<String> allset = all.collect(Collectors.toSet());
        for (String s : allset) {
            String[] strings = StringUtils.splitByWholeSeparator(s, null);
            log.info("{} {} {} {} {} {}", strings[0], strings[1], strings[3], StringUtils.equals(strings[2], "4") ? "餐饮" : "渔家乐", AesUtil.decrypt(strings[4]), AesUtil.decrypt(strings[5]));
        }
    }

    @Test
    public void merchant2() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/merchant2.txt"));
        Stream<String> orderAmt = Files.lines(Paths.get("src/test/resources/file/orderAmt.txt"));
        Set<String> allset = all.collect(Collectors.toSet());
        Set<String> amtSet = orderAmt.collect(Collectors.toSet());
        Map<String, List<String>> map = new HashMap<>();
        for (String s : amtSet) {
            String[] split = StringUtils.splitByWholeSeparator(s, null);
            if (!map.containsKey(split[0])) {
                map.put(split[0], new ArrayList<>());
            }
            List<String> list = map.get(split[0]);
            list.add(s);
        }
        for (String s : allset) {
            BigDecimal allAmt = BigDecimal.ZERO;
            BigDecimal refundAmt = BigDecimal.ZERO;
            Integer orderCount = 0;
            String[] strings = StringUtils.splitByWholeSeparator(s, null);
            if (map.containsKey(strings[3])) {
                List<String> list = map.get(strings[3]);
                for (String ele : list) {
                    String[] split = StringUtils.splitByWholeSeparator(ele, null);
                    allAmt = allAmt.add(new BigDecimal(split[2]));
                    refundAmt = refundAmt.add(new BigDecimal(split[4]));
                    orderCount += Integer.parseInt(split[1]);
                }
            }
            log.info("{} {} {} {} {} {} {} {} ", strings[0], strings[1], strings[2], strings[3], strings[4], allAmt, refundAmt, orderCount);
        }
    }

    @Test
    public void merchant3() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/merchant2.txt"));
        Stream<String> orderAmt = Files.lines(Paths.get("src/test/resources/file/orderAmt.txt"));
        Set<String> allset = all.collect(Collectors.toSet());
        Set<String> amtSet = orderAmt.collect(Collectors.toSet());
        Set<String> merchantNAme = new HashSet<>();
        for (String s : allset) {
            String[] strings = StringUtils.splitByWholeSeparator(s, null);
            merchantNAme.add(strings[3]);
        }
        HashSet<String> no = new HashSet<>();
        for (String s : amtSet) {
            String[] split = StringUtils.splitByWholeSeparator(s, null);
            if (!merchantNAme.contains(split[0])) {
                no.add(split[0]);
            }
        }
        no.forEach(System.out::println);
    }

    @Test
    public void merchant4() throws Exception {
        String startDate = "2025-07-01";
        String endDate = "2025-09-30";
        IslandUtil islandUtil = new IslandUtil();
        List<MerchantInfoDTO> merchantInfoDTOS = islandUtil.getMerchantList();
        log.info("商户数量：{}", merchantInfoDTOS.size());
        List<HotelHomestayDTO> hotelList = islandUtil.getHotelList();
        log.info("酒店数量：{}", hotelList.size());
        List<MerchantInfoExcel> res = new ArrayList<MerchantInfoExcel>();
        for (MerchantInfoDTO merchantInfoDTO : merchantInfoDTOS) {
            MerchantInfoExcel excel = new MerchantInfoExcel();
            excel.setMerchantId(merchantInfoDTO.getId().toString());
            excel.setMerchantName(merchantInfoDTO.getName());
            excel.setCompanyName(merchantInfoDTO.getCompanyName());
            excel.setMerchantType(merchantInfoDTO.getMerchantCategory().toString());
            excel.setMerchantStatus(merchantInfoDTO.getStatus());
            excel.setCreditCode(merchantInfoDTO.getCreditCode());
            List<MerchantFlowRecordDTO> getrecord = islandUtil.getrecord(merchantInfoDTO.getId().toString(), startDate, endDate, merchantInfoDTO.getMerchantCategory().toString());
            if (CollectionUtils.isEmpty(getrecord)) {
                res.add(excel);
                continue;
            }
            log.info("商户{}，流水{}条", merchantInfoDTO.getName(), getrecord.size());
            BigDecimal payAmt = getrecord.stream().filter(e -> e.getFlowType() == 1).map(MerchantFlowRecordDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            Long orderCount = getrecord.stream().filter(e -> e.getFlowType() == 1).map(MerchantFlowRecordDTO::getNum).count();
            BigDecimal refundAmt = getrecord.stream().filter(e -> e.getFlowType() == 2).map(MerchantFlowRecordDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            excel.setOrderCount(orderCount.intValue());
            excel.setPayAmt(payAmt);
            excel.setRefundAmt(refundAmt);
            res.add(excel);
        }
        for (HotelHomestayDTO hotelHomestayDTO : hotelList) {
            MerchantInfoExcel excel = new MerchantInfoExcel();
            excel.setMerchantId(hotelHomestayDTO.getId().toString());
            excel.setMerchantName(hotelHomestayDTO.getName());
            excel.setCompanyName(hotelHomestayDTO.getOperateProject());
            excel.setMerchantType("酒店民宿");
            excel.setMerchantStatus(hotelHomestayDTO.getOperateStatus());
            excel.setCreditCode(hotelHomestayDTO.getCreditCode());
            List<MerchantFlowRecordDTO> getrecord = islandUtil.getrecord(hotelHomestayDTO.getId().toString(), startDate, endDate, "2");
            if (CollectionUtils.isEmpty(getrecord)) {
                res.add(excel);
                continue;
            }
            log.info("商户{}，流水{}条", hotelHomestayDTO.getName(), getrecord.size());
            BigDecimal payAmt = getrecord.stream().filter(e -> e.getFlowType() == 1).map(MerchantFlowRecordDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            Long orderCount = getrecord.stream().filter(e -> e.getFlowType() == 1).map(MerchantFlowRecordDTO::getNum).count();
            BigDecimal refundAmt = getrecord.stream().filter(e -> e.getFlowType() == 2).map(MerchantFlowRecordDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            excel.setOrderCount(orderCount.intValue());
            excel.setPayAmt(payAmt);
            excel.setRefundAmt(refundAmt);
            res.add(excel);
        }
        if (CollectionUtils.isEmpty(res)) {
            return;
        }
        for (MerchantInfoExcel re : res) {
            log.info("{},{},{},{},{},{},{},{},{}"
                    , re.getMerchantId(), re.getMerchantName(),
                    re.getCompanyName(), re.getMerchantType(), re.getMerchantStatus(),
                    re.getCreditCode(), re.getPayAmt(), re.getRefundAmt(), re.getOrderCount());
        }
    }

    @Test
    public void orderFind() throws Exception {
        Stream<String> all = Files.lines(Paths.get("src/test/resources/file/testorder.txt"));
        List<String> orderNos = Files.lines(Paths.get("src/test/resources/file/orderNos.txt")).collect(Collectors.toList());
        Set<String> allset = all.collect(Collectors.toSet());
        Map map = new HashMap<String, String>();
        for (String s : allset) {
            String[] split = s.split("\t");
            map.put(split[1], split[0]);
        }
        for (String orderNo : orderNos) {
            System.out.println(orderNo + ":" + map.get(orderNo));
        }
    }

    @Test
    public void scenic() throws Exception {
        List<String> local = Files.lines(Paths.get("src/test/resources/file/local.txt")).collect(Collectors.toList());
        List<String> scenic = Files.lines(Paths.get("src/test/resources/file/scenic.txt")).collect(Collectors.toList());
        System.out.println(local.size());
        System.out.println(scenic.size());
        HashSet<String> set = new HashSet<>(local);
        HashSet<String> set1 = new HashSet<>(scenic);
        for (String s : set1) {
            if (!set.contains(s)) {
                System.out.println(s);
            }
        }

        System.out.println("------------");
        for (String s : set) {
            if (!set1.contains(s)) {
                System.out.println(s);
            }
        }
        System.out.println("------------");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : local) {
            if (!map1.containsKey(s)) {
                map1.put(s, 1);
            } else {
                map1.put(s, map1.get(s) + 1);
            }
        }
        for (String s : scenic) {
            if (!map2.containsKey(s)) {
                map2.put(s, 1);
            } else {
                map2.put(s, map2.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                System.out.println(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            Integer value = entry.getValue();
            Integer value2 = map2.get(entry.getKey());
            if (value != value2) {
                System.out.println(entry.getKey());
            }
        }
    }


    @Test
    public void getHouseBaseInfo() {
        IslandUtil util = new IslandUtil();
        List<HotelHomestayDTO> hotelList = util.getHotelList();
        Assert.notEmpty(hotelList);
        hotelList.forEach(e -> {
            List<HouseBaseDTO> houseBaseList = util.getHouseBaseList(e.getId().toString());
            houseBaseList.forEach(houseBaseDTO -> {
                HouseBaseDTO houseBaseDetail = util.getHouseBaseDetail(houseBaseDTO.getId().toString());
                HouseBookDTO houseBook = houseBaseDetail.getHouseBook();
                log.info("{},{},{},{},{},{},{},{}", e.getId(), e.getName(), houseBaseDTO.getName(), houseBook.getRefundRule()
                        , houseBook.getCancelDay(), houseBook.getCancelTime(), houseBook.getDeductType(), houseBook.getDeductRatio());
            });
        });
    }

    @Test
    public void huaniaoTest() throws Exception {
        Set<String> local = Files.lines(Paths.get("src/test/resources/file/HNlocal.txt")).collect(Collectors.toSet());
        Map<String, String> map = new HashMap<>(3837);
        Map<String, String> map2 = new HashMap<>(3837);
        Map<String, Integer> mapCount = new HashMap<String, Integer>();
        for (String s : local) {
            String[] split = s.split(",");
            map.put(split[1], split[2]);
            map2.put(split[1], split[0]);
            if (!mapCount.containsKey(split[2])) {
                mapCount.put(split[2], 1);
            } else {
                mapCount.put(split[2], mapCount.get(split[2]) + 1);
            }
        }
        log.info("{}", map.size());
        List<String> scenic = Files.lines(Paths.get("src/test/resources/file/HNThree1.txt")).collect(Collectors.toList());
        log.info("{}", scenic.size());
        Set<String> collect = scenic.stream().collect(Collectors.toSet());
        for (String orderid : local) {
            String[] split = orderid.split(",");
            if ((StringUtils.equals(split[2], "1") || StringUtils.equals(split[2], "2")) && !collect.contains(split[1])) {
                log.warn("不存在的订单" + orderid);
            }
        }
        for (String orderid : scenic) {
            if (!map.containsKey(orderid) || !StringUtils.equals(map.get(orderid), "2")) {
                log.warn(orderid + "  " + map2.get(orderid));
                //log.warn(map.get(orderid));
            }
        }

        //for (String orderid : scenic) {
        //    if (!map.containsKey(orderid)) {
        //        log.warn(orderid);
        //        //log.warn(map.get(orderid));
        //    }
        //}
        log.info("{}", mapCount);

    }

    @Test
    public void htorder() throws Exception {
        List<String> list = Files.lines(Paths.get("src/test/resources/file/htOrder.txt")).collect(Collectors.toList());
        IslandUtil islandUtil = new IslandUtil();
        List<String> orderNos = new ArrayList<>();
        for (String s : list) {
            String[] split = StringUtils.split(s, "\t");
            orderNos.add(split[0]);
        }
        List<IsOrderDTO> isOrderDTOS = islandUtil.orderQuery(orderNos);
        Map<String, String> map = isOrderDTOS.stream().collect(Collectors.toMap(IsOrderDTO::getOrderCode, IsOrderDTO::getLinkJson));
        for (String s : list) {
            String[] split = StringUtils.split(s, "\t");
            String json = map.get(split[0]);
            JSONObject jsonObject = JSONObject.parseObject(json);
            System.out.println(s + "\t" + jsonObject.getString("homestayId") + "\t" + jsonObject.getString("homestayName"));
        }
    }

    @Test
    public void allOrderCheck() throws Exception {
        //批量获取目录C:\Users\您好\Downloads\dzd下的所有文件
        Map<String, BigDecimal> map = new HashMap<>();
        IslandUtil islandUtil = new IslandUtil();
        List<IcbcFLowData> arrayList = new ArrayList<>();
        Files.walk(Paths.get("C:\\Users\\您好\\Downloads\\dzd")).filter(Files::isRegularFile)
                .filter(e -> StringUtils.startsWith(e.getFileName().toString(), "2025"))
                .forEach(e -> {
                    try {
                        List<String> list = Files.lines(e, Charset.forName("GBK")).collect(Collectors.toList());
                        for (int i = 3; i < list.size() - 1; i++) {
                            String data = list.get(i);
                            String[] split = StringUtils.splitByWholeSeparatorPreserveAllTokens(data, ",");
                            String isPay = StringUtils.splitByWholeSeparatorPreserveAllTokens(split[8], "\"")[1];
                            String payTime = StringUtils.splitByWholeSeparatorPreserveAllTokens(split[1], "\"")[1];
                            String orderDate = StringUtils.splitByWholeSeparatorPreserveAllTokens(split[2], "\"")[1];
                            String payAmount = split[12];
                            String orderAmount = split[21];
                            String orderCode = StringUtils.splitByWholeSeparatorPreserveAllTokens(split[17], "\"")[1];
                            IcbcFLowData icbcFLowData = new IcbcFLowData();
                            icbcFLowData.setPayType(isPay);
                            icbcFLowData.setPayAmount(new BigDecimal(payAmount));
                            icbcFLowData.setOrderAmount(new BigDecimal(orderAmount));
                            icbcFLowData.setPaymentTime(DateUtils.parseDate(payTime, "yyyy-MM-dd HH:mm:ss"));
                            icbcFLowData.setOrderCode(orderCode);
                            icbcFLowData.setOrderDate(DateUtils.parseDate(orderDate, "yyyy-MM-dd"));
                            arrayList.add(icbcFLowData);
                        }
                    } catch (IOException ex) {
                        log.error("{}", e);
                        throw new RuntimeException(ex);
                    }
                });
        BigDecimal nofound = BigDecimal.ZERO;
        BigDecimal nofound2 = BigDecimal.ZERO;
        BigDecimal allpayAmt = BigDecimal.ZERO;
        BigDecimal allorderAmt = BigDecimal.ZERO;
        for (IcbcFLowData icbcFLowData : arrayList) {
            Date orderDate = icbcFLowData.getOrderDate();
            if (orderDate.compareTo(DateUtil.parseDate("2025-08-01"))>=0&&orderDate.compareTo(DateUtil.parseDate("2025-09-01"))<0) {
                String orderCode = icbcFLowData.getOrderCode();
                IsOrderDTO order = islandUtil.getOrder(orderCode);
                BigDecimal payAmount = icbcFLowData.getPayAmount();
                BigDecimal orderAmount = icbcFLowData.getOrderAmount();
                allpayAmt = allpayAmt.add(payAmount);
                allorderAmt = allorderAmt.add(orderAmount);
                if (order == null) {
                    log.warn("找不到订单号：{}", orderCode);
                    nofound = nofound.add(payAmount);
                    nofound2 = nofound2.add(orderAmount);
                    continue;
                }
                String isPay = icbcFLowData.getPayType();
                Integer orderType = order.getOrderType();
                String orderName = IslandOrderTypeEnum.getNameByCode(orderType);
                if (!map.containsKey(orderName + "-支付-" + isPay)) {
                    map.put(orderName + "-支付-" + isPay, BigDecimal.ZERO);
                    map.put(orderName + "-入账-" + isPay, BigDecimal.ZERO);
                }
                map.put(orderName + "-支付-" + isPay, map.get(orderName + "-支付-" + isPay).add(payAmount));
                map.put(orderName + "-入账-" + isPay, map.get(orderName + "-入账-" + isPay).add(orderAmount));
            }
        }
        Set<Map.Entry<String, BigDecimal>> entries = map.entrySet();
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : entries) {
            res.add(entry.getKey() + "\t" + entry.getValue());
        }
        res.sort(Comparator.comparing(String::toString));
        for (String s : res) {
            log.info(s);
        }
        log.info("未找到的订单(支付)：{}", nofound);
        log.info("未找到的订单(入账)：{}", nofound2);
        log.info("总金额（支付）：{}", allpayAmt);
        log.info("总金额（入账）：{}", allorderAmt);
    }

    @Test
    public void allOrderCheck2() throws Exception {
        List<String> list = Files.lines(Paths.get("C:\\Users\\您好\\Downloads\\dzd\\huifu202504-06.csv")).collect(Collectors.toList());
        String month = "2025-06";
        Map<String, BigDecimal> map = new HashMap<>();
        IslandUtil islandUtil = new IslandUtil();
        BigDecimal nofound = BigDecimal.ZERO;
        BigDecimal allAmt = BigDecimal.ZERO;
        for (int i = 1; i < list.size(); i++) {
            if (!StringUtils.startsWith(list.get(i), month)) {
                continue;
            }
            String[] split = StringUtils.splitByWholeSeparatorPreserveAllTokens(list.get(i), ",");
            String isPay = split[1];
            String amount = split[6];
            String orderCode = split[33];
            allAmt = allAmt.add(new BigDecimal(amount));
            //log.info("{},{},{}", orderCode, isPay, amount);
            if (StringUtils.startsWith(orderCode, "2025")) {
                log.warn("特殊订单号：{}", orderCode);
                nofound = nofound.add(new BigDecimal(amount));
                continue;
            }
            if (StringUtils.isBlank(orderCode)) {
                log.warn("本地订单号：{}", split[4]);
                nofound = nofound.add(new BigDecimal(amount));
                continue;
            }
            if (StringUtils.equals(isPay, "退款交易流水")) {
                List<IsRefundInfoDTO> isRefundInfoDTOS = islandUtil.refundInfoQuery(Collections.singletonList(orderCode));
                if (CollectionUtils.isEmpty(isRefundInfoDTOS)) {
                    log.warn("找不到退款单号：{}", orderCode);
                    nofound = nofound.add(new BigDecimal(amount));
                    continue;
                }
                orderCode = isRefundInfoDTOS.get(0).getOrderCode();
            }
            IsOrderDTO order = islandUtil.getOrder(orderCode);
            if (order == null) {
                log.warn("找不到订单号：{}", orderCode);
                nofound = nofound.add(new BigDecimal(amount));
                continue;
            }
            Integer orderType = order.getOrderType();
            String orderName = IslandOrderTypeEnum.getNameByCode(orderType);
            if (!map.containsKey(orderName + "-" + isPay)) {
                map.put(orderName + "-" + isPay, BigDecimal.ZERO);
            }
            map.put(orderName + "-" + isPay, map.get(orderName + "-" + isPay).add(new BigDecimal(amount)));
        }
        Set<Map.Entry<String, BigDecimal>> entries = map.entrySet();
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : entries) {
            res.add(entry.getKey() + "\t" + entry.getValue());
        }
        res.sort(Comparator.comparing(String::toString));
        for (String s : res) {
            log.info(s);
        }
        log.info("未找到的订单：{}", nofound);
        log.info("总金额：{}", allAmt);
    }

    @Test
    public void test002() throws Exception {
        List<String> list = Files.lines(Paths.get("C:\\Users\\您好\\Downloads\\dzd\\huifu202504-06.csv")).collect(Collectors.toList());
        String month = "202506";
        Map<String, BigDecimal> map = new HashMap<>();
        IslandUtil islandUtil = new IslandUtil();
        for (int i = 1; i < list.size() - 1; i++) {
            String[] split = StringUtils.splitByWholeSeparatorPreserveAllTokens(list.get(i), ",");
            String isPay = split[1];
            String amount = split[6];
            String orderCode = split[33];
            String day = split[2];
            if (!StringUtils.startsWith(day, month)) {
                continue;
            }
            //log.info("{},{},{}", orderCode, isPay, amount);
            if (StringUtils.startsWith(orderCode, "2025")) {
                log.warn("2025订单号：{}", orderCode);
                continue;
            }
            if (StringUtils.startsWith(orderCode, "O")) {
                List<IsOrderDTO> isOrderDTOS = islandUtil.orderQuery(Collections.singletonList(orderCode));
                if (!CollectionUtils.isEmpty(isOrderDTOS)) {
                    Integer orderType = isOrderDTOS.get(0).getOrderType();
                    log.warn("{},{}", orderCode, orderType);
                }
            }
        }
    }
}
