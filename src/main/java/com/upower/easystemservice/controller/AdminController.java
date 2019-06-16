package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;
    //查询所有用户接口
    @GetMapping("/searchAdmin")
    public PageBean searchAdmin(String name, Integer page, Integer limit){
        return adminService.searchAdmin(name,page,limit);
    }
    //添加
    @PostMapping("/insertAdmin")
    public String insertAdmin(Admin admin){
        return adminService.insertAdamin(admin);
    }
    //删除用户
    @GetMapping("/deleteAdmin")
    public String deleteAdmin(int id){
        System.out.println(id);
        return adminService.deleteAdmin(id);
    }
    //修改用户
    @PostMapping("/updateAdmin")
    public String updateAdmin(Admin admin){
        return adminService.updateAdmin(admin);
    }

}
