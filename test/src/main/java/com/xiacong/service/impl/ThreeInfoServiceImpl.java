package com.xiacong.service.impl;


import com.xiacong.model.ThreeInfo;
import com.xiacong.service.ThreeInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 *
 *
 * @author xiacong
 * @Classname ThreeInfoServiceImpl
 * @Version 1.0.0
 * @Date 2025/5/13 13:54
 * @Created by xiacong
 */
@Service
@Slf4j
public class ThreeInfoServiceImpl implements ThreeInfoService {


    @Override
    public ThreeInfo getThreeInfoByKey(String key) {
        ThreeInfo threeInfo = new ThreeInfo();
        threeInfo.setId(1);
        threeInfo.setThreeName("test");
        threeInfo.setThreeSecret("test");
        threeInfo.setThreeKey("test");
        threeInfo.setRemark("test");
        threeInfo.setStatus("0");
        return threeInfo;
    }
}
