package com.xiacong.util;

import com.alibaba.fastjson2.JSONObject;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.compress.utils.Lists;
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
    public void test01(){
        String str="0,1";
        String[] split = str.split(",");
        List<String> list = Arrays.asList(split);
        System.out.println(list);
    }


    @Test
    public void test02() throws Exception{
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        String express = "1+2>value";
        context.put("value", 3);
        Object execute = runner.execute(express, context, null, true, false);
        System.out.println(execute);
    }
    @Test
    public void test03(){
        String text="<p>东方化工</p><p>测试公告</p><p><img src=\"https://szfzc.oss-accelerate.aliyuncs.com/20231229/test.png\"></p>";
        String reg="<p><img.*?></p>";
        System.out.println(text.replaceAll(reg,""));
    }

    @Test
    public void test04(){
        String test="你好,%s,%s";
        //String format = String.format(test, "aa");
        String format1 = String.format(test, "aa", "bb");
        //String format2 = String.format(test, "aa", "bb", "cc");
        // System.out.println(format);
        System.out.println(format1);
        // System.out.println(format2);

        Formatter formatter = new Formatter();
        Formatter format = formatter.format(test, "aa", "bb");
        System.out.println(format);
        String test2="你好,{},{},{}";
        String[] arg=new String[]{"aa","bb","cc"};
        FormattingTuple aa = MessageFormatter.arrayFormat(test2, arg);
        System.out.println(aa.getMessage());
    }

    @Test
    public void test05(){
        String str="{\"msg\":\"转发成功\",\"type\":null,\"flag\":true,\"status\":\"200\",\"attribute\":\"{\\n  \\\"status\\\": \\\"success\\\",\\n  \\\"data\\\": \\\"[{\\\\\\\"parentvo\\\\\\\":{\\\\\\\"pk_corp\\\\\\\":\\\\\\\"0001\\\\\\\",\\\\\\\"pk_cubasdoc\\\\\\\":\\\\\\\"0001F81000000000QPPW\\\\\\\",\\\\\\\"custcode\\\\\\\":\\\\\\\"CGC00006041\\\\\\\",\\\\\\\"custname\\\\\\\":\\\\\\\"xc/xc2\\\\\\\",\\\\\\\"custshortname\\\\\\\":\\\\\\\"xc/xc2\\\\\\\",\\\\\\\"freecustflag\\\\\\\":false,\\\\\\\"drpnodeflag\\\\\\\":false,\\\\\\\"isconnflag\\\\\\\":false,\\\\\\\"custprop\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"pk_areacl\\\\\\\":\\\\\\\"0001F81000000000099J\\\\\\\",\\\\\\\"areacl_code\\\\\\\":\\\\\\\"02\\\\\\\",\\\\\\\"areacl_name\\\\\\\":\\\\\\\"外部客商\\\\\\\",\\\\\\\"def1\\\\\\\":\\\\\\\"CGC022300\\\\\\\",\\\\\\\"def9\\\\\\\":\\\\\\\"否\\\\\\\",\\\\\\\"creator\\\\\\\":\\\\\\\"#UAP#\\\\\\\",\\\\\\\"createtime\\\\\\\":\\\\\\\"2024-06-18 16:46:22\\\\\\\"},\\\\\\\"ADDR\\\\\\\":[],\\\\\\\"BANK\\\\\\\":[]}]\\\",\\n  \\\"taskNumber\\\": \\\"202406180063\\\"\\n}\"}";
        System.out.println(str);
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.getString("msg"));
        String attribute = jsonObject.getString("attribute");
        System.out.println(attribute);
        JSONObject jsonObject1 = JSONObject.parseObject(attribute);
        System.out.println(jsonObject1.getString("data"));
    }

    @Test
    public void test06(){
        String str="{\n" +
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
        System.out.println(StringUtils.equals(status,"2"));
        System.out.println(invoiceTime);
        Date date = new Date(invoiceTime);
    }

    @Test
    public void test09(){
        String[] split = StringUtils.split("3546354163", "/");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test10(){
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
}
