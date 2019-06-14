package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.User;
import com.upower.easystemservice.service.LoginService;
import com.upower.easystemservice.util.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public JSONResult login(String userName, String password) {
        log.info(userName+"请求登录");
        String token=loginService.login(userName,password);
        if(token!=null){
            return JSONResult.ok(token);
        }
        return JSONResult.errorMsg("账号或密码错误");
    }

    @GetMapping("/get_info")
    public User get_info(String token) {
        return loginService.get_info(token);
    }

}
