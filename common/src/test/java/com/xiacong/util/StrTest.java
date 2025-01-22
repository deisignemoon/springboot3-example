package com.xiacong.util;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiacong
 * @Classname StrTest
 * @Version 1.0.0
 * @Date 2024/4/15 8:45
 * @Created by xiacong
 */
public class StrTest {
    @Test
    public void test01() {
        String str = "0,1";
        String[] split = str.split(",");
        List<String> list = Arrays.asList(split);
        System.out.println(list);
    }


    @Test
    public void test02() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "1+2>value";
        context.put("value", 3);
        Object execute = runner.execute(express, context, null, true, false);
        System.out.println(execute);
    }

    @Test
    public void test03() {
        String text = "<p>fdgv<span style=\"color: rgb(230, 0, 0);\">ewfwefw</span></p>";
        String reg = "<p><img.*?></p>";
        String reg2 = "<p>";
        String reg3 = "</p>";
        String reg4 = "<img.*?>";
        String reg5 = "</span>";
        String reg6 = "<span.*?>";
        text = text.replaceAll(reg, "")
                .replaceAll(reg2, "")
                .replaceAll(reg3, "")
                .replaceAll(reg5, "")
                .replaceAll(reg6, "")
                .replaceAll(reg4, "");
        System.out.println(text);
        text = text.replaceAll(reg2, "");
        System.out.println(text);
        text = text.replaceAll(reg3, "");
        System.out.println(text);
        text = text.replaceAll(reg4, "");
        System.out.println(text);
    }

    @Test
    public void test04() {
        String test = "你好,%s,%s";
        //String format = String.format(test, "aa");
        String format1 = String.format(test, "aa", "bb");
        //String format2 = String.format(test, "aa", "bb", "cc");
        // System.out.println(format);
        System.out.println(format1);
        // System.out.println(format2);

        Formatter formatter = new Formatter();
        Formatter format = formatter.format(test, "aa", "bb");
        System.out.println(format);
        String test2 = "你好,{},{},{}";
        String[] arg = new String[]{"aa", "bb", "cc"};
        FormattingTuple aa = MessageFormatter.arrayFormat(test2, arg);
        System.out.println(aa.getMessage());
    }

    @Test
    public void test05() {
        String str = "{\"msg\":\"转发成功\",\"type\":null,\"flag\":true,\"status\":\"200\",\"attribute\":\"{\\n  \\\"status\\\": \\\"success\\\",\\n  \\\"data\\\": \\\"[{\\\\\\\"parentvo\\\\\\\":{\\\\\\\"pk_corp\\\\\\\":\\\\\\\"0001\\\\\\\",\\\\\\\"pk_cubasdoc\\\\\\\":\\\\\\\"0001F81000000000QPPW\\\\\\\",\\\\\\\"custcode\\\\\\\":\\\\\\\"CGC00006041\\\\\\\",\\\\\\\"custname\\\\\\\":\\\\\\\"xc/xc2\\\\\\\",\\\\\\\"custshortname\\\\\\\":\\\\\\\"xc/xc2\\\\\\\",\\\\\\\"freecustflag\\\\\\\":false,\\\\\\\"drpnodeflag\\\\\\\":false,\\\\\\\"isconnflag\\\\\\\":false,\\\\\\\"custprop\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"pk_areacl\\\\\\\":\\\\\\\"0001F81000000000099J\\\\\\\",\\\\\\\"areacl_code\\\\\\\":\\\\\\\"02\\\\\\\",\\\\\\\"areacl_name\\\\\\\":\\\\\\\"外部客商\\\\\\\",\\\\\\\"def1\\\\\\\":\\\\\\\"CGC022300\\\\\\\",\\\\\\\"def9\\\\\\\":\\\\\\\"否\\\\\\\",\\\\\\\"creator\\\\\\\":\\\\\\\"#UAP#\\\\\\\",\\\\\\\"createtime\\\\\\\":\\\\\\\"2024-06-18 16:46:22\\\\\\\"},\\\\\\\"ADDR\\\\\\\":[],\\\\\\\"BANK\\\\\\\":[]}]\\\",\\n  \\\"taskNumber\\\": \\\"202406180063\\\"\\n}\"}";
        System.out.println(str);
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.getString("msg"));
        String attribute = jsonObject.getString("attribute");
        System.out.println(attribute);
        JSONObject jsonObject1 = JSONObject.parseObject(attribute);
        System.out.println(jsonObject1.getString("data"));
    }

    @Test
    public void test06() {
        String str = "{\n" +
                "        \"terminalNumber\": \"1\",\n" +
                "        \"listFlag\": \"0\",\n" +
                "        \"naturalPersonFlag\": 0,\n" +
                "        \"imgUrls\": \"\",\n" +
                "        \"exTaxAmount\": \"9433.96\",\n" +
                "        \"checker\": \"李四1332323232\",\n" +
                "        \"payee\": \"张三\",\n" +
                "        \"oldInvoiceNo\": \"\",\n" +
                "        \"saleName\": \"航信培训企业199\",\n" +
                "        \"invoiceType\": \"1\",\n" +
                "        \"invoiceNo\": \"\",\n" +
                "        \"specificFactor\": 0,\n" +
                "        \"bankAccount\": \"AS 12344\",\n" +
                "        \"orderNo\": \"1801063582679433216\",\n" +
                "        \"pictureUrl\": \"\",\n" +
                "        \"deptId\": \"\",\n" +
                "        \"telephone\": \"18634208600\",\n" +
                "        \"invoiceCode\": \"\",\n" +
                "        \"serialNo\": \"24061309293403763084\",\n" +
                "        \"statusMsg\": \"开票失败\",\n" +
                "        \"phone\": \"18634208600\",\n" +
                "        \"emailNotifyStatus\": \"4\",\n" +
                "        \"phoneNotifyStatus\": \"4\",\n" +
                "        \"stateUpdateTime\": 1718247575000,\n" +
                "        \"taxAmount\": \"566.04\",\n" +
                "        \"status\": \"22\",\n" +
                "        \"oldInvoiceCode\": \"\",\n" +
                "        \"failCause\": \"A9纸电一体：开票异常，请求超时，请进行手工重推\",\n" +
                "        \"clerkId\": \"\",\n" +
                "        \"remark\": \"\",\n" +
                "        \"pdfUrl\": \"\",\n" +
                "        \"orderAmount\": \"10000.00\",\n" +
                "        \"payerName\": \"王玉莹\",\n" +
                "        \"payerTaxNo\": \"140224200005161225\",\n" +
                "        \"salerAccount\": \"浙江桐庐农村商业银行股份有限公司城南支行201000211280500\",\n" +
                "        \"address\": \"234234324\",\n" +
                "        \"requestSrc\": \"0\",\n" +
                "        \"salerTel\": \"0571-81395853\",\n" +
                "        \"updateTime\": 1718247607000,\n" +
                "        \"invoiceDate\": 1718241994000,\n" +
                "        \"salerAddress\": \"浙江省杭州市西湖区双龙街199号杭政储出【2013】51号地块商业商务用房5＃楼7层701-708室\",\n" +
                "        \"clerk\": \"张晓12345\",\n" +
                "        \"ofdUrl\": \"\",\n" +
                "        \"createTime\": 1718242174000,\n" +
                "        \"productOilFlag\": 0,\n" +
                "        \"extensionNumber\": \"888\",\n" +
                "        \"salerTaxNum\": \"339901999999199\",\n" +
                "        \"listName\": \"\",\n" +
                "        \"invoiceKind\": \"增值税电子普通发票\",\n" +
                "        \"notifyEmail\": \"2677429419@qq.com\",\n" +
                "        \"proxyInvoiceFlag\": \"0\"\n" +
                "    }";
        JSONObject jsonObject = JSONObject.parseObject(str);
        String status = jsonObject.getString("status");
        Long invoiceTime = jsonObject.getLong("invoiceTime");
        System.out.println(StringUtils.equals(status, "2"));
        System.out.println(invoiceTime);
        Date date = new Date(invoiceTime);
    }

    @Test
    public void test09() {
        String[] split = StringUtils.split("3546354163", "/");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test10() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add(null);
        list.add(null);
        list.add("");
        list.add("");
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(set.size());
        System.out.println(set);
    }

    @Test
    public void test11() {
        AA aa = new AA();
        aa.setAge("1");
        aa.setName("asf");
        BB bb = new BB();
        bb.setPrice("25");
        bb.setBookname("<>");
        aa.setBb(bb);
        String jsonString = JSONObject.toJSONString(aa);
        System.out.println(jsonString);
        AA aa1 = JSONObject.parseObject(jsonString, AA.class);
        System.out.println(JSONObject.toJSONString(aa1));
    }

    @Test
    public void test12() {
        List<AA> list = new ArrayList<>();
        list.add(new AA("aa", "20", null));
        list.add(new AA("bb", "20", null));
        list.add(new AA("cc", "20", null));
        list.add(new AA("aa", "20", null));
        list.add(new AA(null, "20", null));
        list.add(new AA("", "20", null));
        Map<String, List<AA>> collect = list.stream().filter(b -> StringUtils.isNotBlank(b.getName())).collect(Collectors.groupingBy(AA::getName));
        System.out.println(collect);
    }

    @Test
    public void test13() {
        int count = 0;
        do {
            try {
                Thread.sleep(1000L);
                count++;
                String title = "sdgvds--,sdfvds--";
                System.out.println("第{}次判断流程标题{}" + count + title);
                if (!StringUtils.contains(title, "--")) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (count < 5);
    }

    @Test
    public void rsaTest() {
        String data = "kk123456";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqzbSXVXjoMwQCSYNnkUz+pHvoJWW2B51YaYJ84+1JjsUUFK5rQTDxvCc7ROKlD4GNC3QQkRyNaoWWWUYwJxFKy803UDv9ERSU0gv/nVKO45B/v9nTEFkfR3bizF8J10OwA7llv6aK8sOnet8Z5fSdZYL/+y21gpd6IWYigdK+/3UGT40gljRyKRISVA05bnhZLWLwDmCF/RzS48aTQVA2MhIjXwNdAbXTgGEL6Ym/D2FQwBBDAIWxl1+WPQqGgZWe3xbSSlc9Wt+m8qD62SvABxzki7zuSA1qX6JymyoGusnE5//Te66VJHtbhWtDeB7SCKx2rffst1kF1j7EbSL1QIDAQAB";
        RSA rsa = new RSA(null, publicKey);
        String s = rsa.encryptBase64(data, KeyType.PublicKey);
        System.out.println(s);
    }

    @Test
    public void splitTest() {
        String str = "1,2,,3,4,,5";
        String[] split = StringUtils.splitByWholeSeparator(str, ",,");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
