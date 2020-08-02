package com.example.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gulimall.product.entity.SpuInfoEntity;
import com.example.common.utils.PageUtils;
import java.util.Map;

/**
 * spu信息
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-02 18:36:07
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
