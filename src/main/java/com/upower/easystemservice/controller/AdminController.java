package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService service;

    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    public void insertAdmin(Admin admin){
        service.insertAdamin(admin);
    }
}
