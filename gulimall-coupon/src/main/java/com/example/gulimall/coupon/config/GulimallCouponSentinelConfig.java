package com.example.gulimall.coupon.config;

//import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
//import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
//import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.fastjson.JSON;
//import com.example.common.exception.BizCodeEnum;
//import com.example.common.utils.R;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.adapter.DefaultServerWebExchange;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.WebFluxCallbackManager;
import com.example.common.sentinel.UrlBlockHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 自定义限流异常处理
 * @Created: with IntelliJ IDEA.
 * @author: jx512337
 * @createTime: 2020-07-13 11:30
 **/

@Configuration
public class GulimallCouponSentinelConfig {

    public GulimallCouponSentinelConfig() {
        //spring cloud alibaba 2.2.x以上整合不支持 更改为webflux响应式流方式
//        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
//            @Override
//            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
//                R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMessage());
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json");
//                response.getWriter().write(JSON.toJSONString(error));
//
//            }
//        });
        WebFluxCallbackManager.setBlockHandler(new UrlBlockHandler());



    }

}
