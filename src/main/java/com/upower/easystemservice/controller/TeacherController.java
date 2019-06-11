package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Teacher;
import com.upower.easystemservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //查询所有用户接口
    @GetMapping("/searchTeacher")
    public PageBean searchTeacher(String name, Integer page, Integer limit){
        return teacherService.searchTeacher(name,page,limit);
    }
    //添加
    @PostMapping("/insertTeacher")
    public String insertTeacher(Teacher teacher){
        return teacherService.insertTeacher(teacher);
    }
    //删除用户
    @GetMapping("/deleteTeacher")
    public String deleteTeacher(int id){
        System.out.println(id);
        return teacherService.deleteTeacher(id);
    }
    //修改用户
    @PostMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }
}
