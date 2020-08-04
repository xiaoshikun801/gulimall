package com.example.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gulimall.coupon.entity.CouponEntity;
import com.example.gulimall.coupon.service.CouponService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * 优惠券信息
 *
 * @author jx512337
 * @email jx512337@gmail.com
 * @date 2020-08-03 00:45:31
 */

/**
 nacos配置中心
 *1、引入依赖
 2、资源目录下创建bootstrap.properties
 spring.application.name=gulimall-coupon
 spring.cloud.nacos.server-addr=127.0.0.1:8848
 3、nacos配置管理添加配置
 * dataId[gulimall-coupon.properties]
 4、开启自动刷新注解@RefreshScope动态获取配置文件值
 5、添加获取配置文件属性值注解@value使用配置项

 配置中心核心概念:
 命名空间
 配置集
 配置集ID
 配置分组

 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;

    @RequestMapping("/test")
    public R testConfigCenter(){
        return R.ok().put("name",name).put("age",age);
    }

    @RequestMapping("/member/list")
    public R memberCoupon(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减100");
        return R.ok().put("coupons",Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
