package com.example.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 整合Mybatis-Plus
 * 1、导入依赖
 * <p><!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter --></>
 * <dependency>
 * <groupId>com.baomidou</groupId>
 * <artifactId>mybatis-plus-boot-starter</artifactId>
 * <version>3.3.2</version>
 * </dependency>
 * 2、注解扫描
 * 3、配置数据源（导入数据库驱动  application.yml配置数据源相关信息）
 * 4、配置Mybatis-Plus相关信息 sql映射文件及主键递增策略等
 */

//@MapperScan("com.example.gulimall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
