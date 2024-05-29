package com.xiacong.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiacong
 * @Classname StreamTest
 * @Version 1.0.0
 * @Date 2024/3/27 16:58
 * @Created by xiacong
 */
public class StreamTest {
    @Test
    public void test01(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        List<Integer> updateIds = list.stream().filter(userId -> null != userId).collect(Collectors.toList());
        System.out.println(updateIds);

        System.out.println(System.currentTimeMillis());
    }
}
