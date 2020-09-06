package com.example.gulimall.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: jx512337
 * @createTime: 2020-06-29 19:56
 **/

@Controller
public class LoginController {

    @PostMapping(value = "/doLogin")
    public String doLogin() {

        //登录成功跳转，跳回到登录页

        return null;
    }

}
