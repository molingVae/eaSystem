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
    public String insertSelectCourse(StuCourse stuCourse,String name) {
        Integer stuid =selectCourseMapper.selectStuidByname(name);
        stuCourse.setStuid(stuid);
        int i = selectCourseMapper.insertStuCourse(stuCourse);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
