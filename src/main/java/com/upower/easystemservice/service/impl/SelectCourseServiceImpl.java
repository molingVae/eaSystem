package com.upower.easystemservice.service.impl;

import com.upower.easystemservice.mapper.SelectCourseMapper;
import com.upower.easystemservice.pojo.StuCourse;
import com.upower.easystemservice.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectCourseServiceImpl implements SelectCourseService {
    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Override
    public String insertSelectCourse(StuCourse course) {
        Integer stuid =selectCourseMapper.selectStuidByname(course.getName());
        course.setStuid(stuid);
        int i = selectCourseMapper.insertStuCourse(course);
        if (i > 0) {
            return "选课成功";
        } else {
            return "选课失败";
        }
    }
}
