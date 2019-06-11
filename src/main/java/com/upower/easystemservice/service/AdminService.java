package com.upower.easystemservice.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.AdminMapper;
import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService  {
    @Autowired
    private AdminMapper mapper;
    //查询所有用户,分页
    public PageBean getAllAdmin(int pageCode, int pageSize){
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Admin> page = (Page<Admin>) mapper.getAllAdmin();
        return new PageBean(page.getTotal(),page.getResult());
    }
    //添加用户
    public void insertAdamin(Admin admin){
        mapper.insertAdamin(admin);
    }
}
