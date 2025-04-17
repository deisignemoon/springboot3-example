package com.xiacong.service.impl;

import cn.hutool.core.io.FileUtil;
import com.xiacong.model.LineSearchDTO;
import com.xiacong.service.ShengsikeyunService;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author xiacong
 * @Classname ShengsikeyunService
 * @Version 1.0.0
 * @Date 2025/3/4 8:43
 * @Created by xiacong
 */
@Service
public class ShengsikeyunServiceImpl implements ShengsikeyunService {

    @Override
    public String queryLine(LineSearchDTO dto) {
        //从路径src/main/resources/ticket.json中读取文件，并返回文件内所有字符串内容
        if (dto.getStartPortNo() == 1028 && dto.getEndPortNo() == 1011) {
            return new String(FileUtil.readBytes("ticket.json"));
        } else if (dto.getStartPortNo() == 1011 && dto.getEndPortNo() == 1028) {
            return new String(FileUtil.readBytes("ticket2.json"));
        }
        return null;
    }
}
