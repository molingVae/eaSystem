package com.upower.easystemservice.service;


import com.upower.easystemservice.mapper.AdminMapper;
import com.upower.easystemservice.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService  {
    @Autowired
    private AdminMapper mapper;

    public void insertAdamin(Admin admin){
        mapper.insertAdamin(admin);
    }
}
