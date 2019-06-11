package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Student;
import com.upower.easystemservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //查询所有用户接口
    @GetMapping("/searchTeacher")
    public PageBean searchTeacher(String name, Integer page, Integer limit){
        return studentService.searchStudent(name,page,limit);
    }
    //添加
    @PostMapping("/insertTeacher")
    public String insertTeacher(Student student){
        return studentService.insertStudent(student);
    }
    //删除用户
    @GetMapping("/deleteTeacher")
    public String deleteTeacher(int id){
        System.out.println(id);
        return studentService.deleteStudent(id);
    }
    //修改用户
    @PostMapping("/updateTeacher")
    public String updateTeacher(Student student){
        return studentService.updateStudent(student);
    }
}
