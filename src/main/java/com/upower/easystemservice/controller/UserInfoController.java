package com.upower.easystemservice.controller;

import com.upower.easystemservice.service.UserInfoService;
import com.upower.easystemservice.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-16 16:05
 */
@RestController
@CrossOrigin(origins = "*")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getInfo")
    public JSONResult getInfo(String token) {
        Object data = userInfoService.getUserInfo(token);
        return JSONResult.ok(data);
    }

    @PostMapping("/upPass")
    public String upPass(String name,String oldpassword ,String newpassword){
        return userInfoService.upPass(name,oldpassword,newpassword);
    }

}
