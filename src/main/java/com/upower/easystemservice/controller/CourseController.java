package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.Course;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;
    //添加课程
    @PostMapping("/insertCourse")
    public String insertCourse(Course course){
        return courseService.insertCoures(course);
    }
    //查询课程接口
    @GetMapping("/searchCourse")
    public PageBean searchCourse(String name, Integer page, Integer limit){
        return courseService.searchCoures(name,page,limit);
    }
    //删除课程
    @GetMapping("/deleteCourse")
    public String deleteCourse(int id){
        return courseService.deleteCoures(id);
    }
    //修改课程
    @PostMapping("/updateCourse")
    public String updateCourse(Course course){
        return courseService.updateCoures(course);
    }
}

