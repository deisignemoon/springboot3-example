package com.xiacong.filter;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.constant.CommonConstant;
import com.xiacong.model.aggreate.UserAggreate;
import io.undertow.security.api.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * dubbo请求上下文过滤器
 * @author xiacong
 */
@Slf4j
@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER}, order = -30001)
public class RemoteCurUserFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //判断是消费者  还是 服务提供者
        RpcContext context = RpcContext.getContext();
        if (context.isConsumerSide()) {
            log.info("dubbo消费端请求{}(地址{})服务{}:{}",context.getRemoteApplicationName()
                    ,context.getRemoteAddressString()
                    ,context.getServiceKey()
                    , JSONObject.toJSONString(context.getArguments()));
            //消费者 将用户信息set至上下文中
            Authentication curUser = null;
            try {
                curUser = SecurityContextHolder.getContext().getAuthentication();
            } catch (Exception e) {
                log.warn("当前上下文不存在用户信息");
            }
            if (curUser != null) {
                log.debug("用dubbo发送用户信息");
                context.setAttachment(CommonConstant.CURUSER,
                        JSONObject.toJSONString(curUser));
            }
        } else {
            //获取请求报文
            log.info("dubbo服务端收到来自{}(地址{}){}的请求:{}",context.getRemoteApplicationName(),
                    context.getRemoteAddressString(),
                    invoker.getInterface(),
                    JSONObject.toJSONString(context.getArguments()));
            //取出业务流水号
            String curUser = context.getAttachment(CommonConstant.CURUSER);
            if (StringUtils.isNotBlank(curUser)) {
                log.debug("dubbo请求中存在用户信息");
                Authentication authentication = JSONObject.parseObject(curUser, Authentication.class);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        Result res = invoker.invoke(invocation);
        log.info("dubbo响应报文:{}", JSONObject.toJSONString(res.getValue()));
        return res;
    }
}
