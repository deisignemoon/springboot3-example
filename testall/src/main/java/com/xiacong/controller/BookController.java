package com.xiacong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiacong.common.result.ResultVO;
import com.xiacong.common.util.ExportUtils;
import com.xiacong.common.util.ImportUtil;
import com.xiacong.mapper.BookMapper;
import com.xiacong.model.domain.Book;
import com.xiacong.model.dto.BookExportDTO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/api/book")
@Slf4j
public class BookController {

    @Resource
    private BookMapper mapper;

    @GetMapping(value = "{pageNum}/{pageSize}", produces = "application/json")
    public ResultVO<PageInfo<Book>> findAll(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> all = mapper.findAll();
        PageInfo<Book> info = new PageInfo<>(all);
        return ResultVO.ok(info);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Book findById(@PathVariable Long id) {
        return mapper.findAllByIdBook(id);
    }

    /**
     * 下载数据模板
     * 模块的原因是根据模板填写数据，上传的数据才不会出差错
     * 为什么这样？具体原因你懂的
     */

    @GetMapping("/download/template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        // 调用接口，并传入空数据，在导出已经做出判断，
        // 说明这个接口是下载模板，不会往表格里面写数据
        ExportUtils.exportData(response, null , BookExportDTO.class);
    }



    /**
     * 导出
     */

    @GetMapping("/export")
    public void exportRole(HttpServletResponse response) throws IOException {
        // 数据库获取数据，Mybatis-plus的方法，不知道的可以学习学习MP
        //List<UserDO> userDOList = userService.list();
        List<Book> books = mapper.findAll();
        // 调用导出工具类的方法，传入对应的参数，简单吧
        ExportUtils.exportData(response, convert2(books) , BookExportDTO.class);
    }

    /**
     * 导入
     */

    @PostMapping("/import")
    public void importsEntity(@RequestParam("file") MultipartFile file) throws Exception {
        // 调用ImportUtil工具类来获取实体对象列表
        // 传入接口获取的文件和实体类，就可以获取到数据，简单吧
        List<BookExportDTO> entities = ImportUtil.importEntities(file, BookExportDTO.class);
        // 在这里处理导入数据的逻辑
        for (BookExportDTO entity : entities) {
            // 执行对数据的操作，例如保存到数据库等
            mapper.insert(convert1(entity));
        }
    }

    private Book convert1(BookExportDTO entity) {
        Book book = new Book();
        book.setName(entity.getName());
        book.setAgeRating(entity.getAgeRating());
        return book;
    }

    private List<BookExportDTO> convert2(List<Book> entities) {
        return entities.stream().map(entity -> {
            BookExportDTO dto = new BookExportDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
    }


}