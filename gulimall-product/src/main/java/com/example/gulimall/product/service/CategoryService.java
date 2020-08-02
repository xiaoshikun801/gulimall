package com.example.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gulimall.product.entity.CategoryEntity;
import com.example.common.utils.PageUtils;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-02 18:36:07
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

