package com.xiacong.controller;

import com.xiacong.common.util.ImportUtil;
import com.xiacong.model.ImageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 *
 * @author xiacong
 * @Classname FileController
 * @Version 1.0.0
 * @Date 2025/11/19 14:34
 * @Created by xiacong
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {


    @PostMapping("/import")
    public void importsEntity(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, List<ImageDTO>> imageMap = new HashMap<>();
        try (InputStream inputStream = new ByteArrayInputStream(file.getBytes());
             ZipInputStream zis = new ZipInputStream(inputStream, Charset.forName("GBK"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    // 目录
                    continue;
                } else {
                    // 文件处理 - 获取文件名和内容
                    String fileName = entry.getName();
                    log.info("文件: {}", fileName);
                    // 读取文件内容,转为输入流
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }
                    InputStream fileStream = new ByteArrayInputStream(baos.toByteArray());


                    // 读取文件内容
                    if (fileName.endsWith(".jpg")) {
                        //图片处理
                        ImageDTO imageDTO = new ImageDTO();
                        String[] split = StringUtils.split("/");
                        String key = split[1];
                        imageDTO.setKey(key);
                        imageDTO.setName(fileName);
                        //图片上传oss
                        String url=null;
                        imageDTO.setUrl(url);
                        if (!imageMap.containsKey(key)) {
                            imageMap.put(key, new ArrayList<ImageDTO>());
                        }
                        imageMap.get(key).add(imageDTO);
                    } else if (fileName.endsWith(".xlsx")) {
                        //excel处理
                        ImportUtil.importEntities(fileStream, ImageDTO.class);
                        //处理成对象
                    }
                }
                zis.closeEntry();
            }

        } catch (IOException e) {
            log.error("处理ZIP文件失败", e);
        }
    }
}
