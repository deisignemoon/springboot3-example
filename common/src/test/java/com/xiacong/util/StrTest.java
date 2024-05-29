package com.xiacong.util;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.jupiter.api.Test;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

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
}
