package com.example.gulimall.authserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.common.utils.HttpUtils;
import com.example.common.utils.R;
import com.example.common.vo.MemberResponseVo;
import com.example.gulimall.authserver.feign.MemberFeignService;
import com.example.gulimall.authserver.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.example.common.constant.AuthServerConstant.LOGIN_USER;

/**
 * @Description: 处理社交登录请求
 * @Created: with IntelliJ IDEA.
 * @authserveror: jx512337
 * @createTime: 2020-06-28 10:16
 **/

@Slf4j
@Controller
public class Oauthserver2Controller {

    @Autowired
    private MemberFeignService memberFeignService;


    @GetMapping(value = "/oauthserver2.0/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("client_id","2077705774");
        map.put("client_secret","40af02bd1c7e435ba6a6e9cd3bf799fd");
        map.put("grant_type","authserverorization_code");
        map.put("redirect_uri","http://authserver.gulimall.com/oauthserver2.0/weibo/success");
        map.put("code",code);

        //1、根据code换取access_token
        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauthserver2/access_token", "post", new HashMap<>(), map, new HashMap<>());

        //2、处理
        if (response.getStatusLine().getStatusCode() == 200) {
            //获取到了access_token
            String json = EntityUtils.toString(response.getEntity());
            //String json = JSON.toJSONString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);

            //知道了哪个社交用户
            //1）、当前用户如果是第一次进网站，自动注册进来（为当前社交用户生成一个会员信息，以后这个社交账号就对应指定的会员）
            //登录或者注册这个社交用户
            System.out.println(socialUser.getAccess_token());
            //调用远程服务
            R oauthserverLogin = memberFeignService.oauthserverLogin(socialUser);
            if (oauthserverLogin.getCode() == 0) {
                MemberResponseVo data = oauthserverLogin.getData("data", new TypeReference<MemberResponseVo>() {});
                log.info("登录成功：用户信息：{}",data.toString());

                //1、第一次使用session，命令浏览器保存卡号，JSESSIONID这个cookie
                //以后浏览器访问哪个网站就会带上这个网站的cookie
                //TODO 1、默认发的令牌。当前域（解决子域session共享问题）
                //TODO 2、使用JSON的序列化方式来序列化对象到Redis中
                session.setAttribute(LOGIN_USER,data);
                
                //2、登录成功跳回首页
                return "redirect:http://gulimall.com";
            } else {
                
                return "redirect:http://authserver.gulimall.com/login.html";
            }

        } else {
            return "redirect:http://authserver.gulimall.com/login.html";
        }

    }

}
