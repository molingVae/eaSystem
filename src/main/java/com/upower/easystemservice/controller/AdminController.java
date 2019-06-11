package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService service;
    //查询所有用户接口
    @GetMapping("/getAllAdmin")
    public PageBean getAllAdmin(@RequestParam("pageCode") int pageCode, @RequestParam("pageSize") int pageSize){
        return service.getAllAdmin(pageCode,pageSize);
    }
    // 用户添加接口
    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    public void insertAdmin(@RequestBody Admin admin){
        service.insertAdamin(admin);
    }
}
