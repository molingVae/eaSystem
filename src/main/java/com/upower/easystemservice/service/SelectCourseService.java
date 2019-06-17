package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.SelectCourse;

public interface SelectCourseService {

    String insertSelectCourse(SelectCourse course);

    Object  getUserInfo(String token);
}
