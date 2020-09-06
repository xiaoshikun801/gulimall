package com.example.common.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
import com.example.common.exception.BizCodeEnum;
import com.example.common.utils.R;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class UrlBlockHandler implements BlockRequestHandler {
    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
        R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMessage());
        return ServerResponse.status(BizCodeEnum.TO_MANY_REQUEST.getCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(error, R.class);
    }
}
