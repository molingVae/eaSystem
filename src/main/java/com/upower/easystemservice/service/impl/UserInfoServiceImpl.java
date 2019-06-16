package com.upower.easystemservice.service.impl;

import com.upower.easystemservice.mapper.UserInfoMapper;
import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.Student;
import com.upower.easystemservice.pojo.Teacher;
import com.upower.easystemservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-16 16:08
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final String ADMIN="[admin]";
    private final String STUDENT="[student]";
    private final String TEACHER="[teacher]";

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Object getUserInfo(String token) {
        //根据token判断用户角色
        String access = userInfoMapper.getAccessBytoken(token);
        if(ADMIN.equals(access)){
            //管理员
            return userInfoMapper.getAdmin(token);
        }else if(STUDENT.equals(access)){
            //学生
            return userInfoMapper.getStudent(token);

        }else {
            //老师
            return userInfoMapper.getTeacher(token);
        }
    }

    @Override
    public String upPass(String name, String oldPassword, String newpassword) {
        //根据名称取密码
        String password=userInfoMapper.getPassByName(name);
        if(oldPassword.equals(password)){
           int i= userInfoMapper.upPass(name,newpassword);
           if (i>0){
               return "修改成功";
           }else {
               return "密码修改错误";
           }
        }
        return "旧密码不正确";
    }
}
