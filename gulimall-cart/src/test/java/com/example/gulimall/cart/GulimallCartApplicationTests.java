package com.example.gulimall.cart;

import com.example.gulimall.cart.service.CartService;
import com.example.gulimall.cart.vo.CartItemVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

@Slf4j
@SpringBootTest
class GulimallCartApplicationTests {
    @Autowired
    private CartService cartService;

    @Test
    public void contextLoads() throws ExecutionException, InterruptedException {
        CartItemVo cartItemVo = cartService.addToCart(1L, 2);
        log.info("cartItemVo:{}",cartItemVo);
    }
}
