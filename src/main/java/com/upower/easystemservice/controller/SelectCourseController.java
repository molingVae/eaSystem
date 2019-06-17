package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.StuCourse;
import com.upower.easystemservice.service.impl.SelectCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SelectCourseController {
    @Autowired
    private SelectCourseServiceImpl selectCourseService;

    //学生选课（学生）
    @PostMapping("/courseSelection")
    public String insertSelectCourse(StuCourse stuCourse,String name) {
        return selectCourseService.insertSelectCourse(stuCourse,name);
    }
}
