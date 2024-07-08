package com.xiacong.common.util;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.request.QrCodeInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiacong
 * @Classname QrCodeHandler
 * @Version 1.0.0
 * @Date 2024/7/2 14:04
 * @Created by xiacong
 */
@Component
@Slf4j
public class QrCodeHandler {

    /**
     * 二维码宽度
     */
    private static final int width = 250;

    /**
     * 二维码高度
     */
    private static final int height = 250;


    public InputStream handel(QrCodeInfoDTO dto) {
        BufferedImage bufferedImage = QrCodeUtil.generate(JSONObject.toJSONString(dto), width, height);
        String name = dto.getName();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            if (StringUtils.isNotBlank(name)) {
                // 加载原始二维码图片
                BufferedImage combinedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = combinedImage.createGraphics();
                g2d.drawImage(bufferedImage, 0, 0, null);
                g2d.dispose();
                // 添加头信息文字
                g2d = combinedImage.createGraphics();
                Font font = new Font("UTF-8", Font.PLAIN, 10); // 自定义字体和大小
                g2d.setFont(font);
                g2d.setColor(Color.BLACK); // 文字颜色
                // 计算文本的宽度和高度
                FontRenderContext context = g2d.getFontRenderContext();
                Rectangle2D textBounds = font.getStringBounds(name, context);
                int textWidth = (int) textBounds.getWidth();
                int textHeight = (int) textBounds.getHeight();
                // 文本位置调整，假设放在二维码下方居中
                int centerX = (combinedImage.getWidth() - textWidth) / 2;
                int centerY = textHeight;
                // 绘制文本
                g2d.drawString(name, centerX, centerY);
                // 清理并关闭Graphics2D
                g2d.dispose();
                ImageIO.write(combinedImage, "png", os);
            } else {
                ImageIO.write(bufferedImage, "png", os);
            }
        } catch (IOException e) {
            log.error("bufferedImage转为stream发生异常{}", e.getMessage());
            throw new ServiceException("bufferedImage转为stream发生异常");
        }
        return new ByteArrayInputStream(os.toByteArray());
    }

    public Map<String, InputStream> getQrCodes(List<QrCodeInfoDTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        Map<String, InputStream> map = new HashMap<>();
        for (QrCodeInfoDTO dto : dtos) {
            try {
                InputStream result = handel(dto);
                map.put(dto.getNo(), result);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }
}
