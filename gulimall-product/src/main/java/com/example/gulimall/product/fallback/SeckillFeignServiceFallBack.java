package com.example.gulimall.product.fallback;

import com.example.common.exception.BizCodeEnum;
import com.example.common.utils.R;
import com.example.gulimall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: jx512337
 * @createTime: 2020-07-13 14:45
 **/

@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
