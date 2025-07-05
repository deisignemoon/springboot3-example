package com.xiacong.util;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.request.QrCodeInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class QrCodeHandler {

    private static final String BASE64_PREFIX = "data:image/jpg;base64,";


    public InputStream handel(QrCodeInfoDTO dto) {
        QrConfig qrConfig = QrConfig.create();
        qrConfig.setMargin(4);
        BufferedImage bufferedImage = QrCodeUtil.generate(JSONObject.toJSONString(dto), qrConfig);
        byte[] res = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            if (!CollectionUtils.isEmpty(dto.getDrawText())) {
                // 加载原始二维码图片
                BufferedImage combinedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = combinedImage.createGraphics();
                g2d.drawImage(bufferedImage, 0, 0, null);
                g2d.dispose();
                int size = 10;
                // 文本位置调整，假设放在二维码下方居中
                int centerX = (combinedImage.getWidth() - size) / 2;
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
        Font font = new Font("UTF-8", Font.PLAIN, size); // 自定义字体和大小
        g2d.setFont(font);
        g2d.setColor(Color.BLACK); // 文字颜色
        // 绘制文本
        g2d.drawString(text, x, y);
        // 清理并关闭Graphics2D
        g2d.dispose();
    }

    public Map<String, String> getQrCodes(List<QrCodeInfoDTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (QrCodeInfoDTO dto : dtos) {
            try (InputStream stream = handel(dto);) {
                //String name = dto.getName();
                //String folder = OssClientUtil.createFolder("hzyckj", DateUtil.format(new Date(), CommonConstant.DATE_FORMATE4));
                ////上传文件到oss
                //String ossUrl = OssClientUtil.uploadObject2Oss(stream, "hzyckj", folder, dto.getNo() + "/" + name + ".png");
                //log.info("二维码文件 {} 并保存到oss：{}", name, ossUrl);
                //map.put(dto.getNo(), ossUrl);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }

    public String bas464Str(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(bytes);
        return BASE64_PREFIX + new String(encode);

    }

    @Test
    public void test() throws IOException {
        InputStream handel = new QrCodeHandler().handel(new QrCodeInfoDTO(
                """
                        aaa
                        bbb
                        ccc
                        """, "123", "POST", "/aaa/ddd", "null", null));
        //输入流转为文件流并保存
        //FileUtil.writeFromStream(handel, "D:\\code\\springboot3-example\\common\\src\\test\\resources\\file\\test.png");
        byte[] bytes = handel.readAllBytes();
        String s = bas464Str(bytes);
        System.out.println(s);
    }

    @Test
    public void test03(){
        byte[] bytes = HttpUtil.downloadBytes("https://img.xjishu.com/img/zl/2018/6/30/1241359458913.gif");
        //bytes转为InputStream
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String decode = QrCodeUtil.decode(inputStream);
        System.out.println(decode);
    }
}
