package com.example.gulimall.authserver.feign;

import com.example.common.utils.R;
import com.example.gulimall.authserver.vo.SocialUser;
import com.example.gulimall.authserver.vo.UserLoginVo;
import com.example.gulimall.authserver.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @authserveror: jx512337
 * @createTime: 2020-06-27 17:10
 **/

@FeignClient("gulimall-member")
public interface MemberFeignService {

    @PostMapping(value = "/member/member/register")
    R register(@RequestBody UserRegisterVo vo);


    @PostMapping(value = "/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping(value = "/member/member/oauthserver2/login")
    R oauthserverLogin(@RequestBody SocialUser socialUser) throws Exception;

}
