package com.example.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gulimall.product.entity.SkuImagesEntity;
import com.example.common.utils.PageUtils;
import java.util.Map;

/**
 * sku图片
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-02 18:36:07
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

