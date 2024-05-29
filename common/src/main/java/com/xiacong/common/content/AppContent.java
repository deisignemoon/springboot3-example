package com.xiacong.common.content;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiacong
 * @Classname AppContent
 * @Version 1.0.0
 * @Date 2024/4/12 10:15
 * @Created by xiacong
 */
@Data
@Slf4j
public class AppContent implements Serializable {

    /**
     * 上下文
     */
    private Map<String, Object> content = new ConcurrentHashMap<>();

    /**
     * 临时变量
     */
    private Map<String, Object> temp = new ConcurrentHashMap<>();

    /**
     * 请求
     */
    private Object request;

    /**
     * 响应
     */
    private Object response;

    /**
     * 流程异常
     */
    private Exception flowException;

    public AppContent deepClone() {
        AppContent clone = null;
        try {
            //序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.close();
            //反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            clone = (AppContent) in.readObject();
            in.close();
        } catch (IOException e) {
            log.error("序列化失败", e);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

}
