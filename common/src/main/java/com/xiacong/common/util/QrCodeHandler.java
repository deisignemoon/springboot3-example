package com.xiacong.common.util;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.request.QrCodeInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
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

    public InputStream handel(QrCodeInfoDTO dto) {
        QrConfig qrConfig = QrConfig.create();
        qrConfig.setMargin(4);
        BufferedImage bufferedImage = QrCodeUtil.generate(JSONObject.toJSONString(dto), qrConfig);
        String name = dto.getName();
        byte[] res = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            if (StringUtils.isNotBlank(name)) {
                // 加载原始二维码图片
                BufferedImage combinedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = combinedImage.createGraphics();
                g2d.drawImage(bufferedImage, 0, 0, null);
                g2d.dispose();
                int size = 10;
                // 文本位置调整，假设放在二维码下方居中
                int centerX = combinedImage.getWidth();
                List<String> drawText = dto.getDrawText();
                for (int i = 0; i < drawText.size(); i++) {
                    int centerY = combinedImage.getHeight() - size * (i + 1);
                    drawText(combinedImage, drawText.get(i), size, centerX, centerY);
                }
                ImageIO.write(combinedImage, "png", os);
            } else {
                ImageIO.write(bufferedImage, "png", os);
            }
            res = os.toByteArray();
        } catch (IOException e) {
            log.error("bufferedImage转为stream发生异常{}", e.getMessage());
            throw new ServiceException("bufferedImage转为stream发生异常");
        }
        return new ByteArrayInputStream(res);
    }

    private void drawText(BufferedImage combinedImage, String text, int size, int x, int y) {
        Graphics2D g2d = combinedImage.createGraphics();
        // 添加头信息文字
        Font font = new Font("SimSun", Font.PLAIN, size); // 自定义字体和大小
        g2d.setFont(font);
        g2d.setColor(Color.BLACK); // 文字颜色
        // 计算文字宽度以实现居中
        FontMetrics metrics = g2d.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        int centerX = (x - textWidth) / 2;
        g2d.drawString(text, centerX, y);
        // 清理并关闭Graphics2D
        g2d.dispose();
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
