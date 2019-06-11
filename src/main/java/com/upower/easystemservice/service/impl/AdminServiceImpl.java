package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.upower.easystemservice.mapper.AdminMapper;
import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.AdminService;
import com.upower.easystemservice.util.StringRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-11 9:38
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String insertAdamin(Admin admin) {

        String[] acc = {"admin"};
        admin.setToken(StringRandom.getStringRandom(15));
        admin.setAccess(Arrays.toString(acc));
        admin.setAvator("https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        admin.setRoles("0");
        int i = adminMapper.insertAdamin(admin);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /**
     * 模糊查询、分页
     * @param name 名称
     * @param page 页码
     * @param limit 页数
     * @return
     */
    @Override
    public PageBean searchAdmin(String name, Integer page, Integer limit) {

        Page<Admin> pages;
        PageHelper.startPage(page, limit);//开启分页

        //若不查询
        if (StringUtils.isEmpty(name)) {
            pages = (Page<Admin>) adminMapper.searchAdmin("", "0");
        } else {
            pages = (Page<Admin>) adminMapper.searchAdmin(name, "0");

        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

}
