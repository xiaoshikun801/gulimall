package com.example.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 调用远程服务
 * 引入open-feign
 * 编写接口 告诉springcloud 需要远程调用
 *        声明接口每一个方法调用哪个远程服务的哪个需求
 * 开启远程调用功能
 */
@EnableFeignClients(basePackages = "com.example.gulimall.member.feign")
@MapperScan("com.example.gulimall.member.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
