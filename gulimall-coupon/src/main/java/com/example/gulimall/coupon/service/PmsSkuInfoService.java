package com.example.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.gulimall.coupon.entity.PmsSkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-03 00:42:49
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

