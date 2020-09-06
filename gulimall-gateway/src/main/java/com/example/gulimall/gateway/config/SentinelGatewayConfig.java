package com.example.gulimall.gateway.config;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.WebFluxCallbackManager;
import com.example.common.sentinel.UrlBlockHandler;
import org.springframework.context.annotation.Configuration;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import com.alibaba.fastjson.JSON;
//import com.example.common.exception.BizCodeEnum;
//import com.example.common.utils.R;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: jx512337
 * @createTime: 2020-07-13 17:18
 **/

@Configuration
public class SentinelGatewayConfig {

    public SentinelGatewayConfig() {
        WebFluxCallbackManager.setBlockHandler(new UrlBlockHandler());
//        GatewayCallbackManager.setBlockHandler(new BlockRequestHandler() {
//            //网关限流了请求，就会调用此回调
//            @Override
//            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
//
//                R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMessage());
//                String errorJson = JSON.toJSONString(error);
//
//                Mono<ServerResponse> body = ServerResponse.ok().body(Mono.just(errorJson), String.class);
//                return body;
//            }
//        });
    }

}
