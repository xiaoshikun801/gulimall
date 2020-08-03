package com.example.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.gulimall.coupon.entity.PmsBrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-03 00:42:49
 */
public interface PmsBrandService extends IService<PmsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

