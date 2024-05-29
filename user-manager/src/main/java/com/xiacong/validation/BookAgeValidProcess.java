package com.xiacong.validation;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.model.aggreate.UserAggreate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * 自定义权限控制
 *
 * @author xiacong
 * @Classname BookAgeValidProcess
 * @Version 1.0.0
 * @Date 2024/5/29 13:50
 * @Created by xiacong
 */
@Component("bvp")
public class BookAgeValidProcess {

    public Boolean validate(Object book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAggreate aggreate = (UserAggreate) authentication.getPrincipal();
        JSONObject from = JSONObject.from(book);
        LocalDate birthday = aggreate.getUser().getBirthday();
        LocalDate localDate = LocalDate.now().minusYears(from.getInteger("ageRating"));
        Assert.isTrue(birthday.isBefore(localDate), "你的年龄不足以阅读");
        return true;
    }

    public Boolean filte(Object book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAggreate aggreate = (UserAggreate) authentication.getPrincipal();
        LocalDate birthday = aggreate.getUser().getBirthday();
        JSONObject from = JSONObject.from(book);
        LocalDate localDate = LocalDate.now().minusYears(from.getInteger("ageRating"));
        return localDate.isAfter(birthday);
    }
}
