package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.VirtualTableColumnsMapper;
import com.xiacong.model.domain.VirtualTableColumns;
import com.xiacong.service.IVirtualTableColumnsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 虚拟表字段定义表 服务实现类
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Service
public class VirtualTableColumnsServiceImpl extends ServiceImpl<VirtualTableColumnsMapper, VirtualTableColumns> implements IVirtualTableColumnsService {

}
