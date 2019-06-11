package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.PageBean;

public interface AdminService {

    String insertAdamin(Admin admin);

    PageBean searchAdmin(String name, Integer page, Integer limit);

    String deleteAdmin(int id);

    String updateAdmin(Admin admin);
}