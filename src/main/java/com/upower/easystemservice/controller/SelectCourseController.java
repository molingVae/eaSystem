package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.SelectCourse;
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
    public String courseSelection(SelectCourse course) {
        System.out.println(course.toString());
        return selectCourseService.insertSelectCourse(course);
    }

    //选课信息（管理员）
    //选课信息（老师）
}
