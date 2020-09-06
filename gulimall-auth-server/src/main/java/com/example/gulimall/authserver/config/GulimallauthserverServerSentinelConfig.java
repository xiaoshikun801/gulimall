package com.example.gulimall.authserver.config;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.WebFluxCallbackManager;
import com.example.common.sentinel.UrlBlockHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GulimallauthserverServerSentinelConfig {

    GulimallauthserverServerSentinelConfig(){
        WebFluxCallbackManager.setBlockHandler(new UrlBlockHandler());
    }

}
