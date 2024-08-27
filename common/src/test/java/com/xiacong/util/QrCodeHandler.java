package com.xiacong.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.request.QrCodeInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import jakarta.imageio.ImageIO;
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
                int centerX = (combinedImage.getWidth() - size) / 2;
                int centerY = combinedImage.getHeight()-size;
                drawText(combinedImage, name, size, centerX, centerY);
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
        Font font = new Font("UTF-8", Font.PLAIN, size); // 自定义字体和大小
        g2d.setFont(font);
        g2d.setColor(Color.BLACK); // 文字颜色
        // 计算文本的宽度和高度
        //FontRenderContext context = g2d.getFontRenderContext();
        // 绘制文本
        g2d.drawString(text, x, y);
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

    @Test
    public void test() {
        InputStream handel = new QrCodeHandler().handel(new QrCodeInfoDTO(
                """
                         aaa
                         bbb
                         ccc
                         """, "123", "POST", "/aaa/ddd", "null", null));
        //输入流转为文件流并保存
        FileUtil.writeFromStream(handel, "D:\\code\\springboot3-example\\common\\src\\test\\resources\\file\\test.png");
    }
}
