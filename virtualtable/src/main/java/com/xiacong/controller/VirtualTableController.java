package com.xiacong.controller;


import com.xiacong.service.IVirtualTableService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 虚拟表定义表 前端控制器
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@RestController
@RequestMapping("/virtualTable")
public class VirtualTableController {

    @Resource
    private IVirtualTableService virtualTableService;

    @GetMapping("/all")
    public String getVirtualTables(){
        String all=virtualTableService.getAll();
        return all;
    }

}
